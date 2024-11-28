import java.util.*;

public class SummaryGenerator {

    public String generateSummary(String inputText) {
        // Step 1: Split input into sentences
        String[] sentences = inputText.split("(?<!Mr|Mrs|Dr)\\.\\s+");

        // Step 2: Count word frequencies
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            for (String word : words) {
                word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Normalize word
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Step 3: Rank sentences based on word importance
        Map<String, Integer> sentenceScores = new HashMap<>();
        for (String sentence : sentences) {
            int score = 0;
            String[] words = sentence.split("\\s+");
            for (String word : words) {
                word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Normalize word
                if (wordFrequency.containsKey(word)) {
                    score += wordFrequency.get(word);
                }
            }
            sentenceScores.put(sentence, score);
        }

        // Step 4: Select top-ranked sentences
        int summaryLength = sentences.length / 2; // Limit summary to half of the sentences
        PriorityQueue<Map.Entry<String, Integer>> rankedSentences = new PriorityQueue<>(
                Map.Entry.comparingByValue(Comparator.reverseOrder())
        );
        rankedSentences.addAll(sentenceScores.entrySet());

        List<String> summarySentences = new ArrayList<>();
        for (int i = 0; i < summaryLength && !rankedSentences.isEmpty(); i++) {
            summarySentences.add(rankedSentences.poll().getKey());
        }

        // Step 5: Return the summary as a single text block
        return String.join(". ", summarySentences) + ".";
    }
}

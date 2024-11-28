import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextSummarizerApp {
    private final SummaryGenerator summaryGenerator = new SummaryGenerator();
    private final WordProcessor wordProcessor = new WordProcessor();
    private boolean isDarkMode = true;  // Default mode: dark

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Text Summarizer Created By Uzair Ali And Abdul Rehman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = UIComponents.createPanel(new BorderLayout(), isDarkMode ? Color.DARK_GRAY : Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Text Summarizer");
        titleLabel.setFont(StyleManager.getHeaderFont());
        titleLabel.setForeground(isDarkMode ? Color.WHITE : Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        // Input and Summary Panels
        JTextArea inputTextArea = UIComponents.createTextArea();
        JTextArea summaryTextArea = UIComponents.createTextArea();
        summaryTextArea.setEditable(false);

        JLabel inputWordCountLabel = new JLabel("Word Count: 0");
        JLabel summaryWordCountLabel = new JLabel("Word Count: 0");

        JPanel inputPanel = UIComponents.createTextSection("                                       Input Passage", inputTextArea, inputWordCountLabel);
        JPanel summaryPanel = UIComponents.createTextSection("                                     Generated Summary", summaryTextArea, summaryWordCountLabel);

        // Bottom Panel for Buttons
        JPanel buttonPanel = UIComponents.createPanel(new FlowLayout(), isDarkMode ? Color.DARK_GRAY : Color.LIGHT_GRAY);
        JButton summarizeButton = UIComponents.createButton("Summarize");
        JButton clearButton = UIComponents.createButton("Clear");
        JButton themeToggleButton = UIComponents.createButton("Toggle Theme");

        buttonPanel.add(summarizeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(themeToggleButton);

        // Progress Bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setVisible(false); // Hidden initially
        buttonPanel.add(progressBar);

        summarizeButton.addActionListener((ActionEvent e) -> {
            String inputText = inputTextArea.getText().trim();
            if (inputText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter text to summarize.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Show and initialize the progress bar
            progressBar.setVisible(true);
            progressBar.setIndeterminate(false);
            progressBar.setValue(0);

            // Perform summary generation in the background
            SwingWorker<String, Void> worker = new SwingWorker<>() {
                @Override
                protected String doInBackground() throws Exception {
                    // Simulate progress (e.g., 10 steps)
                    for (int i = 0; i <= 100; i += 10) {
                        Thread.sleep(100); // Simulated work
                        progressBar.setValue(i);
                    }
                    // Generate the summary
                    return summaryGenerator.generateSummary(inputText);
                }

                @Override
                protected void done() {
                    try {
                        // Update the summary text area
                        String summary = get();
                        summaryTextArea.setText(summary);

                        // Update Word Counts
                        inputWordCountLabel.setText("                                                    Word Count: " + wordProcessor.countWords(inputText));
                        summaryWordCountLabel.setText("                                                  Word Count: " + wordProcessor.countWords(summary));

                        // Hide the progress bar
                        progressBar.setVisible(false);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "An error occurred while generating the summary.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            };
            worker.execute();
        });

        clearButton.addActionListener(e -> {
            inputTextArea.setText("");
            summaryTextArea.setText("");
            inputWordCountLabel.setText("                             Word Count: 0");
            summaryWordCountLabel.setText("                           Word Count: 0");
            progressBar.setValue(0);
            progressBar.setVisible(false);
        });

        themeToggleButton.addActionListener(e -> {
            isDarkMode = !isDarkMode;
            updateTheme(frame, inputTextArea, summaryTextArea, inputWordCountLabel, summaryWordCountLabel, titlePanel, buttonPanel);
        });

        // Main Layout
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.add(inputPanel);
        mainPanel.add(summaryPanel);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Apply the theme after all panels and components are initialized
        updateTheme(frame, inputTextArea, summaryTextArea, inputWordCountLabel, summaryWordCountLabel, titlePanel, buttonPanel);

        frame.setVisible(true);
    }

    // Method to update theme based on current mode
    private void updateTheme(JFrame frame, JTextArea inputTextArea, JTextArea summaryTextArea, JLabel inputWordCountLabel, JLabel summaryWordCountLabel, JPanel titlePanel, JPanel buttonPanel) {
        Color backgroundColor = isDarkMode ? Color.BLACK : Color.WHITE;
        Color textColor = isDarkMode ? Color.WHITE : Color.BLACK;
        Color panelColor = isDarkMode ? Color.BLACK : Color.BLACK;
        Color buttonColor = isDarkMode ? new Color(0, 153, 76) : new Color(0, 102, 204);  // Green for dark mode, Blue for light mode

        frame.getContentPane().setBackground(backgroundColor);
        inputTextArea.setBackground(backgroundColor);
        inputTextArea.setForeground(textColor);
        summaryTextArea.setBackground(backgroundColor);
        summaryTextArea.setForeground(textColor);
        inputWordCountLabel.setForeground(textColor);
        summaryWordCountLabel.setForeground(textColor);

        // Update button colors
        for (Component comp : frame.getContentPane().getComponents()) {
            if (comp instanceof JButton) {
                comp.setBackground(buttonColor);
                comp.setForeground(Color.WHITE);
            }
        }

        // Update panel colors (passed as parameters)
        titlePanel.setBackground(panelColor);
        buttonPanel.setBackground(panelColor);
    }
}

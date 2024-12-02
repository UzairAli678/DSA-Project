# DSA-Project Documentation
 

# **Text Summarizer Project**
This project is a GUI-based **Text Summarizer** application written in Java. It provides an intuitive user interface for inputting text and generating concise summaries. The application also displays word counts for both the input text and the generated summary.

---

## **Features**
1. Input text column for entering a passage.
2. Summary column that displays a concise version of the input text.
3. Real-time word count for both input and summary.
4. Clear button to reset fields.
5. Attractive and user-friendly GUI with a black-themed interface.

---

## **Class Descriptions**

### 1. **`TextSummarizerApp`**
This is the main class responsible for initializing the application, managing the GUI layout, and handling user interactions.

#### **Key Methods**
- **`createAndShowGUI()`**
  - Initializes and displays the GUI components.
  - Sets up the main layout including title panel, input panel, summary panel, and button panel.
  - Handles the button click events for *Summarize* and *Clear* actions.

- **`main(String[] args)`**
  - Entry point for the application. Uses `SwingUtilities` to ensure the GUI runs on the Event Dispatch Thread.

#### **Logic Used**
- It integrates other utility classes (`UIComponents`, `SummaryGenerator`, and `WordProcessor`) for modularity.
- Adds action listeners to interact with the `SummaryGenerator` and `WordProcessor` classes for generating summaries and counting words.

---

### 2. **`SummaryGenerator`**
This class encapsulates the logic for generating a summary of the input text.  

#### **Key Methods**
- **`generateSummary(String inputText)`**
  - Takes the input text and reduces it to approximately half its length while retaining key phrases and meaning.
  - Uses **word frequency analysis** to prioritize significant words.

#### **Logic Used**
- **Word Frequency Analysis**:
  - Breaks the text into sentences and tokens.
  - Computes word frequencies to rank sentences.
  - Selects sentences that contribute most to the overall meaning.

---

### 3. **`WordProcessor`**
Handles operations related to text analysis such as counting words.

#### **Key Methods**
- **`countWords(String text)`**
  - Counts the total number of words in a given string using regex splitting.

---

### 4. **`UIComponents`**
A utility class for creating reusable GUI components. Ensures consistent styling across the application.

#### **Key Methods**
- **`createPanel(LayoutManager layout, Color background)`**
  - Creates a styled panel with a specific layout and background color.
- **`createTextArea()`**
  - Returns a preconfigured `JTextArea` with styling for input and summary text.
- **`createTextSection(String title, JTextArea textArea, JLabel wordCountLabel)`**
  - Creates a labeled section containing a `JTextArea` and a word count display.
- **`createButton(String label)`**
  - Returns a styled button.
- **`createButtonPanel()`**
  - Creates a panel for buttons like *Summarize* and *Clear*.
- **`createFooterPanel(String text)`**
  - Adds a footer with credits.
  
---

### 5. **`StyleManager`**
Manages styles such as fonts and colors used in the application.

#### **Key Methods**
- **`getHeaderFont()`**
  - Provides the font for headers.
- **`getBodyFont()`**
  - Provides the font for body text.
- **`getHeaderColor()`**
  - Returns the color for the header background.
- **`getTextColor()`**
  - Returns the color for text.

---

## **Flow of Execution**

1. **Initialization**:
   - `TextSummarizerApp` initializes the GUI using `UIComponents` and applies styles from `StyleManager`.

2. **Input Handling**:
   - User enters text in the input column.
   - On clicking *Summarize*, the input text is processed by `SummaryGenerator`.

3. **Summary Generation**:
   - `SummaryGenerator` analyzes the input text.
   - Generates a concise summary based on word frequencies and sentence importance.

4. **Word Count**:
   - `WordProcessor` counts words in both input and summary text.

5. **Clear Functionality**:
   - Clears all fields and resets word counts.

---

## **Technologies and Concepts Used**
1. **Java Swing**:
   - Used for GUI components such as `JFrame`, `JTextArea`, `JPanel`, and `JButton`.

2. **Natural Language Processing (NLP)**:
   - Word frequency analysis for summarization.

3. **Object-Oriented Programming (OOP)**:
   - Modular design with reusable classes and methods.

4. **Regular Expressions**:
   - Used in `WordProcessor` to count words efficiently.

---

## **How to Run**
1. Compile the Java files using a compatible JDK.
2. Run the `TextSummarizerApp` class to launch the application.
3. Enter text in the input column and click *Summarize*.
4. Use the *Clear* button to reset fields.

---

## **Authors**
Developed by **Uzair Ali** and **Rehman**.
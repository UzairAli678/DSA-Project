import javax.swing.*;
import java.awt.*;

public class UIComponents {
    public static JPanel createPanel(LayoutManager layout, Color bgColor) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(bgColor);
        return panel;
    }

    public static JTextArea createTextArea() {
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setBackground(StyleManager.getBackgroundColor());
        textArea.setForeground(StyleManager.getTextColor());
        textArea.setFont(StyleManager.getSectionFont());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(StyleManager.getButtonColor());
        button.setForeground(Color.WHITE);
        button.setFont(StyleManager.getSectionFont());
        return button;
    }

    public static JPanel createTextSection(String title, JTextArea textArea, JLabel wordCountLabel) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(StyleManager.getBackgroundColor());

        JLabel label = new JLabel(title);
        label.setFont(StyleManager.getSectionFont());
        label.setForeground(StyleManager.getTextColor());

        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(wordCountLabel, BorderLayout.SOUTH);

        return panel;
    }
}


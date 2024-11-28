public class MainApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            TextSummarizerApp app = new TextSummarizerApp();
            app.createAndShowGUI();
        });
    }
}

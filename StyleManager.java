import java.awt.*;

public class StyleManager {
    public static Font getHeaderFont() {
        return new Font("Times New Roman", Font.BOLD, 38);
    }

    public static Font getSectionFont() {
        return new Font("Times New Roman", Font.BOLD, 19);
    }

    public static Color getHeaderColor() {
        return new Color(34, 23, 83);
    }

    public static Color getBackgroundColor() {
        return Color.GRAY;
    }

    public static Color getTextColor() {
        return Color.WHITE;
    }

    public static Color getButtonColor() {
        return new Color(0, 153, 86);
    }
}


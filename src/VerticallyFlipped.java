public class VerticallyFlipped implements TextBlock {
    // Fields
    TextBlock content;
    // Constructor
    public VerticallyFlipped (TextBlock content) {
        this.content = content;
    }

    public String row(int i) throws Exception {
        int height = content.height();
        return content.row(height - i - 1);
    }

    public int height() {
        return content.height();
    }

    public int width() {
        return content.width();
    }
}

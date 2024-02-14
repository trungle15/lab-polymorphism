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

    public TextBlock getContent() {
        return content;
    }

    public boolean eqv(TextBlock other) {
        boolean b = other instanceof VerticallyFlipped && this instanceof VerticallyFlipped;
        return (b && this.content.eqv(other.getContent()));
      }
}

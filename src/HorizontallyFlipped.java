public class HorizontallyFlipped implements TextBlock{
    
    TextBlock content;
    
    // Constructors
    public HorizontallyFlipped(TextBlock content) {
        this.content = content;
    };

    public String row(int i) throws Exception {
        return new StringBuilder(content.row(i)).reverse().toString();
    }

    public int width() {
        return this.content.width();
    }
    public int height() {
        return content.height();
    }

    public TextBlock getContent() {
        return content;
    }

    public boolean eqv(TextBlock other) {
        boolean b = other instanceof HorizontallyFlipped && this instanceof HorizontallyFlipped;
        return (b && this.content.eqv(other.getContent()));
      }
}

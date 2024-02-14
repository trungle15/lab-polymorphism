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
}

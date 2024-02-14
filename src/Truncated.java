public class Truncated implements TextBlock{
    
    // Fields
    TextBlock content;
    int width;

    // Constructors

    public Truncated (TextBlock content, int width) throws Exception {
        this.content = content;
        if (width < 0) {
            throw new Exception("Invalid max width");
        } else {
            this.width = width;
        }
    }

    public String row(int i) throws Exception {
        int contentWidth = this.content.width();
        if (contentWidth > width) {
            return content.row(i).substring(0, width);
        } else {
        return content.row(i);}
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
    boolean b = other instanceof Truncated && this instanceof Truncated;
    return (b && this.content.eqv(other.getContent()));
    }
}

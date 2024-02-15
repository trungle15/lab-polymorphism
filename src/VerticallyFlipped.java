/**
 * A vertical flip of a text block
 * 
 * @author Trung Le
 * @author Marina Ananias
 */


public class VerticallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  TextBlock content;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Constructs a VerticallyFlipped object with the specified content.
   * @param content the text block to be vertically flipped
   */
  public VerticallyFlipped (TextBlock content) {
    this.content = content;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Returns the row at the specified index, counting from the top.
   * @param i the index of the row
   * @return the row at the specified index
   * @throws Exception if the index is out of bounds
   */
  public String row(int i) throws Exception {
    int height = content.height();
    return content.row(height - i - 1);
  }

  /**
   * Returns the height of the text block.
   * @return the height of the text block
   */
  public int height() {
    return content.height();
  }

  /**
   * Returns the width of the text block.
   * @return the width of the text block
   */
  public int width() {
    return content.width();
  }

  /**
   * Returns the content of the text block.
   * @return the content of the text block
   */
  public TextBlock getContent() {
    return content;
  }

  /**
   * Checks if this VerticallyFlipped object is equivalent to the specified TextBlock object.
   * Two VerticallyFlipped objects are considered equivalent if their content is equivalent.
   * @param other the TextBlock object to compare with
   * @return true if the objects are equivalent, false otherwise
   */
  public boolean eqv(TextBlock other) {
    boolean b = other instanceof VerticallyFlipped && this instanceof VerticallyFlipped;
    return (b && this.content.eqv(other.getContent()));
  }
}

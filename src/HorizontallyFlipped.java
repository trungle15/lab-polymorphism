/**
 * A horizontal flip of a text box
 * 
 * @author Trung Le
 * @author Marina Ananias
 */

/**
 * Represents a horizontally flipped text block.
 * This class implements the TextBlock interface.
 */
public class HorizontallyFlipped implements TextBlock{
  
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  TextBlock content;
  
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
   * Constructs a HorizontallyFlipped object with the specified content.
   * @param content the text block to be horizontally flipped
   */
  public HorizontallyFlipped(TextBlock content) {
    this.content = content;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Returns the text of the specified row in reverse order.
   * @param i the index of the row
   * @return the horizontally flipped text of the row
   * @throws Exception if the row index is out of bounds
   */
  public String row(int i) throws Exception {
    return new StringBuilder(content.row(i)).reverse().toString();
  } // String row(int i)

  /**
   * Returns the width of the horizontally flipped text block.
   * @return the width of the text block
   */
  public int width() {
    return this.content.width();
  } // int width()

  /**
   * Returns the height of the horizontally flipped text block.
   * @return the height of the text block
   */
  public int height() {
    return content.height();
  } // int height()

  /**
   * Returns the content of the horizontally flipped text block.
   * @return the content of the text block
   */
  public TextBlock getContent() {
    return content;
  } // TextBlock getContent()

  /**
   * Checks if the horizontally flipped text block is equivalent to the specified text block.
   * Two horizontally flipped text blocks are considered equivalent if their content is equivalent.
   * @param other the text block to compare with
   * @return true if the text blocks are equivalent, false otherwise
   */
  public boolean eqv(TextBlock other) {
    boolean b = other instanceof HorizontallyFlipped && this instanceof HorizontallyFlipped;
    return (b && this.content.eqv(other.getContent()));
  } // eqv(TextBlock other)
}

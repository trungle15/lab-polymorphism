/**
 * A text block truncates its content width by a parameter
 * 
 * @author Trung Le
 * @author Marina Ananias
 */

/**
 * Represents a truncated text block that limits the width of the content.
 */
public class Truncated implements TextBlock{
  
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  TextBlock content;
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Constructs a Truncated object with the specified content and maximum width.
   * 
   * @param content the text block content
   * @param width the maximum width of the truncated text block
   * @throws Exception if the width is negative
   */
  public Truncated (TextBlock content, int width) throws Exception {
    this.content = content;
    if (width < 0) {
      throw new Exception("Invalid max width");
    } else {
      this.width = width;
    }
  }
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Returns the truncated text of the specified row.
   * 
   * @param i the row index
   * @return the truncated text of the specified row
   * @throws Exception if the row index is out of bounds
   */
  public String row(int i) throws Exception {
    int contentWidth = this.content.width();
    if (contentWidth > width) {
      return content.row(i).substring(0, width);
    } else {
      return content.row(i);
    }
  }
  
  /**
   * Returns the height of the truncated text block.
   * 
   * @return the height of the truncated text block
   */
  public int height() {
    return content.height();
  }

  /**
   * Returns the maximum width of the truncated text block.
   * 
   * @return the maximum width of the truncated text block
   */
  public int width() {
    return width;
  }
  
  /**
   * Returns the content of the truncated text block.
   * 
   * @return the content of the truncated text block
   */
  public TextBlock getContent() {
    return content;
  }

  /**
   * Checks if the specified text block is equivalent to this truncated text block.
   * 
   * @param other the text block to compare
   * @return true if the specified text block is equivalent to this truncated text block, false otherwise
   */
  public boolean eqv(TextBlock other) {
    boolean b = other instanceof Truncated && this instanceof Truncated;
    return (b && this.content.eqv(other.getContent()));
  }
}

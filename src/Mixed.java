/**
 * A text box that justify left for odd rows and right for even rows
 * 
 * @author Trung Le
 * @author Marina Ananias
 */


public class Mixed implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock content;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by centering content.
   */
  public Mixed(TextBlock content) {
    this.content = content;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    
    int h = this.content.height();

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    TextBlock rjBlock = new RightJustified(content, (this.content.width() + 10));
    String mw = TBUtils.spaces(10);

    String result;

    if ((i < h) && (i % 2 == 0)) {
      result = this.content.row(i) + mw;
    }
    else if (i < h) {
      result = rjBlock.row(i);
    }
    else { 
      result = TBUtils.spaces(this.content.width());
    }

    return result;

  } // row(int i)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.content.height();
  } // height() 

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    TextBlock rjBlock = new RightJustified(content, (this.content.width() + 10));

    int iw = this.content.width();
    int rjw = rjBlock.width();
    int w = Math.max(iw, rjw);
    return w;
  } // width()
  
  /**
   * Returns the content of the mixed text block.
   * @return the content of the text block
   */
  public TextBlock getContent() {
    return content;
  } // TextBlock getContent()

  /**
   * Checks if the mixed text block is equivalent to the specified text block.
   * Two mixed text blocks are considered equivalent if their content is equivalent.
   * @param other the text block to compare with
   * @return true if the text blocks are equivalent, false otherwise
   */
  public boolean eqv(TextBlock other) {
    boolean b = other instanceof Mixed && this instanceof Mixed;
    return (b && this.content.eqv(other.getContent()));
  } // boolean eqv(TextBlock other)

} // class Concated


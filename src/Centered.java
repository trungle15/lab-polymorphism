/**
 * A text box that is center justified.
 *
 * @author Trung Le
 * @author Marina Ananias
 */

public class Centered implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * TextBlock to center
   */
  TextBlock content;

  /**
   * TextBlock Margins
   */
  TextBlock margins;

  /**
   * New block width
   */  
  int newWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by centering content.
   */
  public Centered(TextBlock content, int newWidth) {
    this.content = content;
    this.newWidth = newWidth; 
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

    String result;
    String mw = TBUtils.spaces((this.newWidth - (content.width())) / 2);

    if (i < h) {
      result =  mw + this.content.row(i) + mw;
    }
    else {
      result = TBUtils.spaces(Integer.parseInt(mw) + (this.content.width()) + Integer.parseInt(mw));
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
    return newWidth;
  } // width()

  public TextBlock getContent() {
    return content;
  } // TextBlock getContent()

  public boolean eqv(TextBlock other) {
    boolean b = other instanceof Centered && this instanceof Centered;
    return (b && this.content.eqv(other.getContent()));
  } // boolean eqv(TextBlock other)

} // class Centered
  

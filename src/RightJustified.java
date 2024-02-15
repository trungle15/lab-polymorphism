/**
 * A text block that justify right for its content
 * 
 * @author Trung Le
 * @author Marina Ananias
 */


public class RightJustified implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * TextBlock to center
   */
  TextBlock content;

  /**
   * TextBlock Left Margin
   */
  TextBlock leftMargin;

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
  public RightJustified(TextBlock content, int newWidth) {
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
    String mw = TBUtils.spaces(this.newWidth - (content.width()));

    if (i < h) {
      result =  mw + this.content.row(i);
    }
    else {
      result = TBUtils.spaces(Integer.parseInt(mw) + (this.content.width()));
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
  }

  /**
   * Checks if the right justified text block is equivalent to the specified text block.
   * Two right justified text blocks are considered equivalent if their content is equivalent.
   * @param other the text block to compare with
   * @return true if the text blocks are equivalent, false otherwise
   */
  public boolean eqv(TextBlock other) {
    boolean b = other instanceof RightJustified && this instanceof RightJustified;
    return (b && this.content.eqv(other.getContent()));
  }
  
} // class RightJustified

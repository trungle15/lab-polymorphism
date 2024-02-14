// given a text block and a width, builds a new block that centers the block within that width.
public class Centered implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * TextBlock to center
   */
  TextBlock initialBlock;

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
  public Centered(TextBlock initialBlock, int newWidth) {
    this.initialBlock = initialBlock;
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
    
    int h = this.initialBlock.height();

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String result;
    String mw = TBUtils.spaces((this.newWidth - (initialBlock.width())) / 2);

    // Don't think you need this?

    if (i < h) {
      result =  mw + this.initialBlock.row(i) + mw;
    }
    else {
      result = TBUtils.spaces(Integer.parseInt(mw) + (this.initialBlock.width()) + Integer.parseInt(mw));
    }
    // result =  mw + this.initialBlock.row(i) + mw;
    return result;

  } // row(int i)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.initialBlock.height();
  } // height() 

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return newWidth;
  } // width()

} // class Centered
  

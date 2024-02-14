// given a text block and a width, builds a new block that 
// right-justifies the input block within that width.
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

  public boolean eqv(TextBlock other) {
    boolean b = other instanceof RightJustified && this instanceof RightJustified;
    return (b && this.content.eqv(other.getContent()));
  }
  
} // class RightJustified

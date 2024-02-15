import org.junit.Test;
import static org.junit.Assert.*;

public class TextBlockTests {

  @Test
  public void testTruncated() throws Exception {
    Truncated truncatedBox = new Truncated(new BoxedBlock(new TextLine("Hello")), 3);
    Truncated truncatedBox2 = new Truncated(new BoxedBlock(new TextLine("Hello World")), 3);
    Truncated truncatedBox3 = new Truncated(
        new BoxedBlock(new Truncated(new BoxedBlock(new TextLine("Hello World")), 6)), 3);
    Truncated edgeCaseBox = new Truncated(new BoxedBlock(new TextLine("Hello")), 0);

    // Test `row` method
    assertEquals("+--", truncatedBox.row(0));
    assertEquals("|He", truncatedBox.row(1));

    // Test `height` and `width` method
    assertEquals(3, truncatedBox.height());
    assertEquals(3, truncatedBox.width());

    // Test edge case: 0 width
    assertEquals("", edgeCaseBox.row(0));

    // Test `eq`: Same memory
    assertEquals(true, TBUtils.eq(truncatedBox, truncatedBox));
    assertEquals(false, TBUtils.eq(truncatedBox, truncatedBox2));

    // Test `equal`: Same line
    assertEquals(true, TBUtils.equal(truncatedBox, truncatedBox2));
    assertEquals(false, TBUtils.equal(truncatedBox, truncatedBox3));

    // Test `eqv`: Same construction
    assertEquals(false, truncatedBox.eqv(truncatedBox2));
    assertEquals(true, truncatedBox.eqv(truncatedBox));
  }

  @Test
  public void testCentered() throws Exception {
    Centered centeredBox = new Centered(new TextLine("Hello"), 15);
    Centered centeredBox2 = new Centered(new TextLine("Hello"), 15);
    TextBlock centerText = new TextLine("     Hello     ");
    Centered emptyCenteredBox = new Centered(new TextLine(""), 15);

    // Test `row` method
    assertEquals("     Hello     ", centeredBox.row(0));

    // Test `height` and `width` method
    assertEquals(1, centeredBox.height());
    assertEquals(15, centeredBox.width());

    // Test edge case: empty box
    assertEquals("              ", emptyCenteredBox.row(0));

    // Test `eq`: Same memory
    assertEquals(true, TBUtils.eq(centeredBox, centeredBox));
    assertEquals(false, TBUtils.eq(centeredBox, centeredBox2));

    // Test `equal`: Same line
    assertEquals(true, TBUtils.equal(centeredBox, centeredBox));
    assertEquals(true, TBUtils.equal(centeredBox, centerText));

    // Test `eqv`: Same construction
    assertEquals(true, centeredBox.eqv(centeredBox2));
    assertEquals(false, centeredBox.eqv(centerText));
  }
  
  @Test
  public void testRightJustified() throws Exception {

    // Create RightJustified instances
    RightJustified rightJustifiedBox = new RightJustified(new BoxedBlock(new TextLine("Hello")), 10);
    RightJustified rightJustifiedBox2 = new RightJustified(new BoxedBlock(new TextLine("Hello World")), 20);
    RightJustified rightJustifiedBox3 = new RightJustified(new BoxedBlock(new RightJustified(new BoxedBlock(new TextLine("Hello World")), 15)), 20);
    RightJustified emptyRightJustified = new RightJustified(new TextLine(""), 10);

    // Test `row` method for right justification
    assertEquals("   +-----+", rightJustifiedBox.row(0));
    assertEquals("   |Hello|", rightJustifiedBox.row(1));
    assertEquals("   +-----+", rightJustifiedBox.row(2));

    // Test `height` and `width` method
    assertEquals(3, rightJustifiedBox.height());
    assertEquals(10, rightJustifiedBox.width());

    // Test edge case
    assertEquals("          ", emptyRightJustified.row(0));

    // Test `eq`: Same memory
    assertTrue(TBUtils.eq(rightJustifiedBox, rightJustifiedBox));
    assertFalse(TBUtils.eq(rightJustifiedBox, rightJustifiedBox2));

    // Test `equal`: Same line
    assertFalse(TBUtils.equal(rightJustifiedBox, rightJustifiedBox2));
    assertFalse(TBUtils.equal(rightJustifiedBox, rightJustifiedBox3));

    // Test `eqv`: Same construction
    assertFalse(rightJustifiedBox.eqv(rightJustifiedBox2));
    assertTrue(rightJustifiedBox.eqv(rightJustifiedBox));
  }

  @Test
  public void testMixed() throws Exception {
    VComposition multiLine = new VComposition(new TextLine("hello"), new TextLine("world"));
    VComposition multiLine2 = new VComposition(new TextLine("hello          "), new TextLine("          world"));
    Mixed mixedBlock = new Mixed(multiLine);
    Mixed mixedBlock2 = new Mixed(multiLine);
    Mixed emptyMixedBlock = new Mixed(new VComposition(new TextLine(""), new TextLine("")));

    // Test `row` method
    assertEquals("hello          ", mixedBlock.row(0));
    assertEquals("          world", mixedBlock.row(1));

    // Test `height` and `width` 
    assertEquals(2, mixedBlock.height());
    assertEquals(15, mixedBlock.width());

    // Test edge case: empty box
    assertEquals("          ", emptyMixedBlock.row(0));

    // Test `eq`: Same memory
    assertTrue(TBUtils.eq(mixedBlock, mixedBlock));
    assertFalse(TBUtils.eq(mixedBlock, mixedBlock2));

    // Test `equal`: Same line
    assertTrue(TBUtils.equal(mixedBlock, mixedBlock2));
    assertTrue(TBUtils.equal(mixedBlock, multiLine2));

    // Test `eqv
    assertTrue(mixedBlock.eqv(mixedBlock));
    assertFalse(mixedBlock.equals(multiLine2));
  }
  

  @Test
  public void testHorizontallyFlipped() throws Exception {
    
    TextLine textLine = new TextLine("hello");
    HorizontallyFlipped flipped = new HorizontallyFlipped(textLine);
    HorizontallyFlipped flippedSame = new HorizontallyFlipped(new TextLine("hello"));
    HorizontallyFlipped flippedDifferent = new HorizontallyFlipped(new TextLine("world"));
    BoxedBlock boxed = new BoxedBlock(textLine);
    HorizontallyFlipped flippedBoxed = new HorizontallyFlipped(boxed);
    HorizontallyFlipped emptyFlipped = new HorizontallyFlipped(new TextLine(""));

    // Test `row` method for correct flipping
    assertEquals("olleh", flipped.row(0));

    // Test `width` and `height` methods
    assertEquals(5, flipped.width());
    assertEquals(1, flipped.height());

    // Test edge case: empty box
    assertEquals("", emptyFlipped.row(0));

    // Test TBUtils.eq for reference equality
    assertFalse(TBUtils.eq(flipped, flippedSame));
    assertTrue(TBUtils.eq(flipped, flipped));

    // Test TBUtils.equal for content equality
    assertTrue(TBUtils.equal(flipped, flippedSame));
    assertFalse(TBUtils.equal(flipped, flippedBoxed));

    // Test `eqv` method
    assertTrue(flipped.eqv(flippedSame));
    assertFalse(flipped.eqv(flippedDifferent));

  }

  @Test
  public void testVerticallyFlipped() throws Exception {

    VComposition multiLine = new VComposition(new TextLine("hello"), new TextLine("world"));

    VerticallyFlipped flippedMultiLine = new VerticallyFlipped(multiLine);
    VerticallyFlipped flippedMultiLinex2 = new VerticallyFlipped(new VerticallyFlipped(multiLine));
    VerticallyFlipped flippedMultiLinex4 = new VerticallyFlipped(new VerticallyFlipped(new VerticallyFlipped(new VerticallyFlipped(multiLine))));
    VerticallyFlipped emptyFlipped = new VerticallyFlipped(new TextLine("")); 


    // Test `row` method for correct flipping
    assertEquals("world", flippedMultiLine.row(0)); // The first row after flipping
    assertEquals("hello", flippedMultiLine.row(1)); // The second row after flipping

    // Test Test `width` and `height` methods
    assertEquals(5, flippedMultiLine.width());
    assertEquals(2, flippedMultiLine.height());

    // Test edge case: empty box
    assertEquals("", emptyFlipped.row(0));

    // Test `eq`: same memory
    assertTrue(TBUtils.eq(flippedMultiLine, flippedMultiLine)); // Same instance
    assertFalse(TBUtils.eq(flippedMultiLine, flippedMultiLinex2)); // Different instances

    // Test `equal`: same line
    assertTrue(TBUtils.equal(flippedMultiLinex2, flippedMultiLinex4)); 
    assertFalse(TBUtils.equal(flippedMultiLine, flippedMultiLinex2));

    // Test `eqv`: same structure
    assertTrue(flippedMultiLinex2.eqv(flippedMultiLinex2));
    assertFalse(flippedMultiLinex2.eqv(flippedMultiLinex4));
  }
}
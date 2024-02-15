import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a regular blocks to use
    TextBlock block = new TextLine("Hello");
    TextBlock block2 = new TextLine("Goodbye");

    // Print out the block
    pen.println("Regular Block");
    TBUtils.print(pen, block);

    // Create new boxed block
    BoxedBlock box1 =  new BoxedBlock(block);
    BoxedBlock box11 =  new BoxedBlock(block);

    // Print out boxed block
    pen.println("Boxed Regular Block");
    TBUtils.print(pen, box1);

    // Create new boxed block
    BoxedBlock box2 =  new BoxedBlock(box1);

    // Print out double boxed block
    pen.println("Double Boxed Regular BLock");
    TBUtils.print(pen, box2);
    pen.println();


    /*                        Centered                        */
    // Create new centered "Hello" in  length of 15
    TextBlock centeredBlock = new Centered(block, 15);

    // Print out centeredBlock
    pen.println("Centered Block");
    TBUtils.print(pen, centeredBlock);
    pen.println();

    // Create new boxed block
    BoxedBlock centeredBox = new BoxedBlock(centeredBlock);

    // Print out boxed centered block
    pen.println("Centered Boxed Block");
    TBUtils.print(pen, centeredBox);
    pen.println();

    /*                                                RightJustified*/
    // Create new right-justified "Hello" in  length of 15
    TextBlock rightJustifiedBlock = new RightJustified(block, 30);

    // Print out rightjustofiedBlock
    pen.println("Right Justified Block");
    TBUtils.print(pen, rightJustifiedBlock);
    pen.println();

    // Create new boxed block
    BoxedBlock rightJustifiedBox = new BoxedBlock(rightJustifiedBlock);

    // Print out boxed right-justified  block
    pen.println("Right Justified Boxed Block");
    TBUtils.print(pen, rightJustifiedBox);
    pen.println();

    /* Mixed                                                */

    TextBlock vComposedBlock = new VComposition (block, block2);

    // Create new concated block of block and block2
    TextBlock mixedBlock = new Mixed(vComposedBlock);

    // Print out concatedBlock
    pen.println("Mixed Block");
    TBUtils.print(pen, mixedBlock);
    pen.println();

    // Create new boxed block
    BoxedBlock mixedBoxedBlock = new BoxedBlock(mixedBlock);

    // Print out boxed right-justified  block
    pen.println("Mixed Boxed Block");
    TBUtils.print(pen, mixedBoxedBlock);
    pen.println();

    /* eq (memory)                                            */
    
    Boolean t = TBUtils.eq(box1, box1);
    Boolean f = TBUtils.eq(box1, box11);

    pen.println("eq(t): " + t);
    pen.println("eq(f): " + f);

    /* eqv (built the same way)                               */

    HorizontallyFlipped boxFlipped2x =  new HorizontallyFlipped(new HorizontallyFlipped (box1));
    HorizontallyFlipped boxFlipped4x =  new HorizontallyFlipped(new HorizontallyFlipped
                                       (new HorizontallyFlipped(new HorizontallyFlipped (box1))));

    pen.println("2x:");
    TBUtils.print(pen, boxFlipped2x);

    pen.println("4x:");
    TBUtils.print(pen, boxFlipped4x);

    VComposition multiLine = new VComposition(new TextLine("hello"), new TextLine("world"));
    Mixed mixedBlocks = new Mixed(multiLine);

    pen.println("LLL");
    TBUtils.print(pen, mixedBlocks);

    pen.println("Expected False: " + boxFlipped2x.eqv(boxFlipped4x));
    pen.println("Expected True: " + box1.eqv(box11));

    /* equal (same lines)                                     */
    pen.println("Expected True: " + TBUtils.equal(boxFlipped4x, boxFlipped2x));
    pen.println("Expected True: " + TBUtils.equal(box1, box11));

    // Clean up after ourselves.
    pen.close();
    
  } // main(String[])

} // class TBExpt

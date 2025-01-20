import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import checkers.CheckersPiece;
import checkers.Color;
import checkers.King;
import checkers.Man;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for the CheckersPiece interface.
 */
public class CheckersPieceTest {
  CheckersPiece pieceA;
  CheckersPiece pieceB;

  @Before
  public void setUp() {
    pieceA = new Man(3, 3, Color.BLACK);
    pieceB = new King(5, 7, Color.WHITE);
  }

  /**
   * Test for getRow().
   */
  @Test
  public void getRowTest() {
    setUp();
    assertEquals(3, pieceA.getRow());
    assertEquals(5, pieceB.getRow());
  }

  /**
   * Test for getColumn().
   */
  @Test
  public void getColumn() {
    setUp();
    assertEquals(3, pieceA.getColumn());
    assertEquals(7, pieceB.getColumn());
  }

  /**
   * Test for getColor().
   */
  @Test
  public void getColorTest() {
    setUp();
    assertEquals(Color.BLACK, pieceA.getColor());
    assertEquals(Color.WHITE, pieceB.getColor());
  }

  /**
   * Test for canMove().
   */
  @Test
  public void canMoveTest() {
    setUp();
    assertFalse(pieceA.canMove(4, 4));
    assertFalse(pieceA.canMove(3, 2));
    assertTrue(pieceA.canMove(2, 2));

    assertTrue(pieceB.canMove(6, 6));
    assertTrue(pieceB.canMove(4, 6));

    // Test for out of border
    CheckersPiece pieceC = new King(6, 6, Color.WHITE);
    assertFalse(pieceC.canMove(7, 8));

    CheckersPiece pieceD = new King(2, 2, Color.BLACK);
    assertFalse(pieceD.canMove(-1, -1));
  }

  @Test
  public void canCaptureTest() {
    setUp();
    assertFalse(pieceA.canCapture(pieceB));

    // Test: Cannot capture the piece with the same color.
    CheckersPiece pieceE = new Man(4, 4, Color.BLACK);
    assertFalse(pieceA.canCapture(pieceE));

    // Test: Can capture the piece with different color yet in the opposite position.
    CheckersPiece pieceF = new King(4, 4, Color.WHITE);
    assertFalse(pieceA.canCapture(pieceF));

    CheckersPiece pieceG = new Man(6, 6, Color.BLACK);
    assertTrue(pieceB.canCapture(pieceG));

    // Test: Can not capture the piece when the piece will be out of border after capturing.
    CheckersPiece pieceH = new Man(4, 4, Color.BLACK);
    CheckersPiece pieceI = new Man(5, 5, Color.WHITE);
    assertFalse(pieceH.canCapture(pieceI));
  }

  /**
   * Test for checking whether the piece is on a white cell.
   * If true, throw an error.
   */
  @Test(expected = IllegalArgumentException.class)
  public void ifPieceOnWhiteCell() {
    new Man(6, 5, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ifPieceHasColor() {
    new Man(1, 1, null);
  }
}


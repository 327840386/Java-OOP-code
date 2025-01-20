import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import solitaire.MarbleSolitaireModelImpl;


/**
 * Test class for MarbleSolitaireModelImpl.
 */
public class MarbleSolitaireModelImplTest {
  private MarbleSolitaireModelImpl game;

  @Before
  public void setUp() {
    game = new MarbleSolitaireModelImpl();
  }

  /**
   * Test the first constructor.
   */
  @Test
  public void testFirstConstructor() {
    System.out.println("Actual game state:\n" + game.getGameState()); // Print actual game state
    assertEquals(
        32, game.getScore());

    String expectedState =
        "    O O O    \n"
            +
            "    O O O    \n"
            +
            "O O O O O O O\n"
            +
            "O O O _ O O O\n"
            +
            "O O O O O O O\n"
            +
            "    O O O    \n"
            +
            "    O O O    ";
    assertEquals(expectedState.trim(), game.getGameState().trim());
  }

  /**
   * Test the constructor with empty.
   */
  @Test
  public void testConstructorWithEmpty() {
    // Initialize game state
    game = new MarbleSolitaireModelImpl(1, 3);

    // Get game state and split into rows
    String[] rows = game.getGameState().split("\n");

    // Locate the correct characters and assert the test
    // Note that here it's assumed each character is followed by a space, except for end of line
    assertEquals("Test the constructor with an empty space at (1,3) sets the correct empty space",
        '_',
        rows[1].charAt(6)); // You may need to adjust this index based on your game board format
  }

  /**
   * Test the constructor with invalid empty position.
   */
  @Test
  public void testConstructorWithInvalidEmpty() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MarbleSolitaireModelImpl(3, 1, 6);
    });
  }

  /**
   * Test the constructor with invalid empty position outside arm.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidArmThickness() {
    new MarbleSolitaireModelImpl(2);
  }

  /**
   * Test the move valid.
   */
  @Test
  public void testMoveValid() {
    game.move(1, 3, 3, 3); // This move will remove the marble at position (2,3)
    assertEquals("Test a valid move decreases the score", 31, game.getScore());

    // Don't use trim(), as it removes leading and trailing whitespaces
    String[] rows = game.getGameState().split("\n");

    // Determine the desired placement of the characters.
    // Assuming that there are no leading spaces and that a space separates each place.
    int fromRow = 1; // The row where marble is expected to be removed
    int toRow = 3;   // The row where marble is expected to move
    int fromCol =
        3 * 2; // Each position occupies two characters width as 'O' or '_' followed by a space
    int toCol = 3 * 2;   // Same as above

    assertEquals("Test the 'from' position is now empty", '_', rows[fromRow].charAt(fromCol));
    assertEquals("Test the 'to' position now contains a marble", 'O', rows[toRow].charAt(toCol));
  }

  /**
   * Test the move invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalid() {
    game.move(1, 3, 1, 5);
  }

  /**
   * Test the IsGameOver.
   */
  @Test
  public void testIsGameOver() {
    assertFalse("Test isGameOver returns false when init", game.isGameOver());
  }

  /**
   * Test the getGameState.
   */
  @Test
  public void testGetGameState() {
    // Expected game state should match the actual game board size
    String expected =
        "        O O O    \n"
            +
            "    O O O    \n"
            +
            "O O O O O O O\n"
            +
            "O O O _ O O O\n"
            +
            "O O O O O O O\n"
            +
            "    O O O    \n"
            +
            "    O O O    ";
    assertEquals("Check the initial game state matches the expected state",
        expected.trim(), game.getGameState().trim());
  }

  /**
   * Test the getScore.
   */
  @Test
  public void testGetScore() {
    assertEquals("Test the score is initially 32", 32, game.getScore());
    game.move(1, 3, 3, 3);
    assertEquals("Test the score is 31 after a move", 31, game.getScore());
  }

  /**
   * Test the constructor with even arm thickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEvenArmThickness() {
    new MarbleSolitaireModelImpl(4);
  }

  /**
   * Test the constructor with negative arm thickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNegativeArmThickness() {
    new MarbleSolitaireModelImpl(-3);
  }

  /**
   * Test the constructor with invalid empty position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidEmptyPosition() {
    new MarbleSolitaireModelImpl(3, 7,
        7); // Assuming normal game board size is 7x7, this position is illegal
  }

  /**
   * Test the constructor with invalid empty position outside arm.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidEmptyPositionOutsideArm() {
    new MarbleSolitaireModelImpl(3, 0, 0); // Outside the play area of the game board
  }

  /**
   * Test the constructor with negative.
   */
  @Test
  public void testNegative() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MarbleSolitaireModelImpl(3, -1, -1);
    });
  }

  /**
   * Test the constructor with negative1.
   */
  @Test
  public void testNegative1() {
    assertThrows(IllegalArgumentException.class, () -> {
      new MarbleSolitaireModelImpl(-1, -1);
    });
  }

  /**
   * Test the constructor with moves available.
   */
  @Test
  public void testIsGameOver_WithMovesAvailable() {
    game.move(1, 3, 3, 3);
    assertFalse("Game should not be over, moves are available.", game.isGameOver());
  }

  /**
   * Test the constructor with moves available1.
   */
  @Test
  public void testIsGameOver_WithMovesAvailable1() {
    game.move(3, 1, 3, 3);
    assertFalse("Game should not be over, moves are available.", game.isGameOver());
  }

  /**
   * Test the constructor with moves available2.
   */
  @Test
  public void testIsGameOver_WithMovesAvailable2() {
    game.move(5, 3, 3, 3);
    assertFalse("Game should not be over, moves are available.", game.isGameOver());
  }

  /**
   * Test the constructor with invalid empty position1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidEmptyPosition1() {
    new MarbleSolitaireModelImpl(3, 1, 1); // Invalid empty position within the arms
  }

  /**
   * Test the constructor with invalid arm thickness1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidArmThickness1() {
    new MarbleSolitaireModelImpl(2); // Even arm thickness
  }

  /**
   * Test the constructor with valid1.
   */
  @Test
  public void testMoveValid1() {
    game.move(3, 1, 3, 3);
    assertEquals(31, game.getScore());
    // Add more assertions as needed
  }

  /**
   * Test the constructor with invalid1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveInvalid1() {
    game.move(1, 3, 1, 5); // Invalid move
  }

  /**
   * Test the constructor with testIsGameOver1.
   */
  @Test
  public void testIsGameOver1() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl();
    game.move(3, 1, 3, 3);
    game.move(3, 4, 3, 2);
    game.move(3, 6, 3, 4);
    game.move(1, 3, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(6, 3, 4, 3);
    assertTrue(game.isGameOver());
  }
}
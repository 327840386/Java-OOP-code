package solitaire;

/**
 * Represents a model for a game of Marble Solitaire.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  /**
   * Represents a piece on the game board.
   */
  public enum BoardPiece {
    MARBLE('O'), // Marble
    EMPTY('_'), // Empty space
    INVALID(' '); // Non-playable area

    private final char symbol;

    BoardPiece(char symbol) {
      this.symbol = symbol;
    }

    public char getSymbol() {
      return symbol;
    }
  }


  // Width of the arms
  private final int armThickness;
  // Game board represented as a 2D array
  private BoardPiece[][] board;

  // Size of the game board
  private final int boardSize;
  private int score;

  /**
   * Constructs a game of Marble Solitaire with a default board.
   */
  public MarbleSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs a game of Marble Solitaire with a default board and a specified empty position.
   *
   * @param emptyRow    row of the empty position
   * @param emptyColumn column of the empty position
   */
  public MarbleSolitaireModelImpl(int emptyRow, int emptyColumn) {
    this(3, emptyRow, emptyColumn);
  }

  // Arm thickness is the sole parameter given by the constructor with one empty middle location.
  public MarbleSolitaireModelImpl(int armThickness) {
    this(armThickness, (armThickness * 3 - 2) / 2, (armThickness * 3 - 2) / 2);
  }

  /**
   * Constructs a game of Marble Solitaire with a specified board and empty position.
   *
   * @param armThickness width of the arms
   * @param emptyRow     row of the empty position
   * @param emptyColumn  column of the empty position
   */
  public MarbleSolitaireModelImpl(int armThickness, int emptyRow, int emptyColumn) {
    this.armThickness = armThickness;
    this.boardSize = armThickness * 3 - 2;
    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Arm thickness must be a positive odd number.");
    }
    if (!isValidPosition(emptyRow, emptyColumn)) {
      throw new IllegalArgumentException("Invalid empty cell position "
          + "(" + emptyRow + "," + emptyColumn + ")");
    }

    initializeBoard(emptyRow, emptyColumn);
  }

  /**
   * Checks if a position is valid on the board.
   *
   * @param row row index
   * @param col column index
   * @return true if the position is valid, false otherwise
   */
  private boolean isValidPosition(int row, int col) {
    // Calculate the bounds of the center square
    int minCenterIndex = armThickness - 1;
    int maxCenterIndex = armThickness + minCenterIndex - 1;

    // Check if position is within the center square
    boolean isInCenterSquare = row >= minCenterIndex && row <= maxCenterIndex
        && col >= minCenterIndex && col <= maxCenterIndex;

    // Calculate the bounds of the arms excluding the center square
    // int minArmIndex = 0;
    // int maxArmIndex = (armThickness * 3 - 2) - 1;

    // Check if position is within the horizontal arms excluding the center square
    boolean isInHorizontalArm = row >= minCenterIndex && row <= maxCenterIndex
        && (col < minCenterIndex || col > maxCenterIndex);

    // Check if position is within the vertical arms excluding the center square
    boolean isInVerticalArm = col >= minCenterIndex && col <= maxCenterIndex
        && (row < minCenterIndex || row > maxCenterIndex);

    // A position is valid if it's in the center square or in one of the arms
    return isInCenterSquare || isInHorizontalArm || isInVerticalArm;
  }

  /**
   * Initializes the game board with marbles and an empty space.
   *
   * @param emptyRow    row of the empty position
   * @param emptyColumn column of the empty position
   */
  private void initializeBoard(int emptyRow, int emptyColumn) {
    this.board = new BoardPiece[boardSize][boardSize];
    this.score = 0;

    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        if (isValidPosition(i, j)) {
          board[i][j] = BoardPiece.MARBLE; // Place marble
          this.score++;
        } else {
          board[i][j] = BoardPiece.INVALID; // Non-playable area
        }
      }
    }

    board[emptyRow][emptyColumn] = BoardPiece.EMPTY; // Set empty space
    this.score--;
  }

  /**
   * Moves a marble from a given position to another position.
   *
   * @param fromRow    row of the marble to move
   * @param fromColumn column of the marble to move
   * @param toRow      row to move the marble to
   * @param toColumn   column to move the marble to
   * @throws IllegalArgumentException if the move is invalid
   */
  @Override
  public void move(int fromRow, int fromColumn, int toRow, int toColumn)
      throws IllegalArgumentException {
    if (!isValidMove(fromRow, fromColumn, toRow, toColumn)) {
      throw new IllegalArgumentException("Invalid move");
    }
    board[fromRow][fromColumn] = BoardPiece.EMPTY;
    board[toRow][toColumn] = BoardPiece.MARBLE;
    board[(fromRow + toRow) / 2][(fromColumn + toColumn) / 2] = BoardPiece.EMPTY;
    this.score--;
  }

  /**
   * Checks if a move is valid.
   *
   * @param fromRow    row of the marble to move
   * @param fromColumn column of the marble to move
   * @param toRow      row to move the marble to
   * @param toColumn   column to move the marble to
   * @return true if the move is valid, false otherwise
   */
  private boolean isValidMove(int fromRow, int fromColumn, int toRow, int toColumn) {
    return isValidPosition(fromRow, fromColumn)
        && isValidPosition(toRow, toColumn)
        && board[fromRow][fromColumn] == BoardPiece.MARBLE
        && board[toRow][toColumn] == BoardPiece.EMPTY
        && Math.abs(fromRow - toRow + fromColumn - toColumn) == 2
        && board[(fromRow + toRow) / 2][(fromColumn + toColumn) / 2] == BoardPiece.MARBLE;
  }

  /**
   * Returns whether the game is over.
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        // Assume here to check if position (i, j) can move left, right, up, or down
        // Below is one way to perform boundary checks:
        if (i - 2 >= 0 && isValidMove(i, j, i - 2, j)) {
          return false;
        }
        if (i + 2 < boardSize && isValidMove(i, j, i + 2, j)) {
          return false;
        }
        if (j - 2 >= 0 && isValidMove(i, j, i, j - 2)) {
          return false;
        }
        if (j + 2 < boardSize && isValidMove(i, j, i, j + 2)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns the current state of the game board.
   *
   * @return the current state of the game board
   */
  @Override
  public String getGameState() {
    StringBuilder state = new StringBuilder();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        state.append(board[i][j].getSymbol()); // Use the symbol provided by the enum
        if (j < boardSize - 1) {
          state.append(" "); // Add space between each cell
        }
      }
      if (i < boardSize - 1) {
        state.append("\n"); //  Add newline between each row
      }
    }
    return state.toString();
  }

  /**
   * Returns the current score of the game.
   *
   * @return the current score of the game
   */
  @Override
  public int getScore() {
    return this.score; // Give back the amount of marbles on the board, or the current score.
  }
}

package checkers;

/**
 * The Abstract Class for CheckerPiece.
 * It defines the position of the piece and if the piece can move or capture.
 */
public abstract class AbstractCheckerPiece implements CheckersPiece {
  protected Color color;
  protected int column;
  protected int row;

  /**
   * Constructor of AbstractCheckerPiece class.
   * @param row row of this piece
   * @param column column of this piece
   * @param color color of this piece
   */
  public AbstractCheckerPiece(int row, int column, Color color) {
    this.row = row;
    this.column = column;
    this.color = color;
    // Check if the piece is on the black cell.
    if (!isOnBlackCell(this.row, this.column)) {
      throw new IllegalArgumentException("The checker is not on the black cell.");
      // Check if the piece is out of the board.
    } else if (!isInBoard(this.row, this.column)) {
      throw new IllegalArgumentException("The checker is out of the board.");
    } else if (this.color == null) {
      throw new IllegalArgumentException("The checker must have a color.");
    }
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.column;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public boolean canCapture(CheckersPiece piece) {
    if (piece.getColor() == this.color) {
      return false;
    } else if (!canMove(piece.getRow(), piece.getColumn())) {
      return false;
    } else {
      int col = (piece.getColumn() - this.getColumn()) * 2 + this.getColumn();
      int row = (piece.getRow() - this.getRow()) * 2 + this.getRow();
      return isInBoard(row, col);
    }
  }

  /**
   * If the checker is on a white cell, return false.
   * @param row row of the checker
   * @param column column of the checker
   * @return if the checker is on the black cell boolean
   */
  public boolean isOnBlackCell(int row, int column) {
    return (row + column) % 2 == 0;
  }

  /**
   * If the checker is out of the board, throw an error.
   * @param row row of the checker
   * @param column column of the checker
   * @return if the checker is out of the border boolean
   */
  public boolean isInBoard(int row, int column) {
    return (row <= 7 && column <= 7 && row >= 0 && column >= 0);
  }
}
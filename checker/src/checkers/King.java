package checkers;

/**
 * A class for King. It uses row, column and color.
 * It can move and capture.
 */
public class King extends AbstractCheckerPiece {
  /**
   * Constructor of AbstractCheckerPiece class.
   *
   * @param row    row of this piece
   * @param column column of this piece
   * @param color  color of this piece
   */
  public King(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int column) {
    if (!isInBoard(row, column)) {
      return false;
    }
    // Check if this color is black, the piece can only go backward.
    return Math.abs(this.column - column) == 1 && Math.abs(this.row - row) == 1;
  }
}

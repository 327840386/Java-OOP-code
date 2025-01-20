package checkers;

/**
 * A Class for Man, using row, column and color.
 * It can move and capture.
 */
public class Man extends AbstractCheckerPiece {
  /**
   * Constructor of AbstractCheckerPiece class.
   *
   * @param row    row of this piece
   * @param column column of this piece
   * @param color  color of this piece
   */
  public Man(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int column) {
    if (!isInBoard(row, column)) {
      return false;
    }
    // Check if this.column and the column is adjacent.
    if (Math.abs(this.column - column) == 1) {
      // Check if this color is black, the piece can only go backward.
      if (this.color == Color.BLACK) {
        return this.row - row == 1;
        // Check if this color is white, the piece can only go forward.
      } else {
        return row - this.row == 1;
      }
    }
    return false;
  }
}

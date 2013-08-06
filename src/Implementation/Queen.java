package Implementation;

/**
 *
 * @author serena
 */
public class Queen extends Piece {

	Queen(int x, int y, int player) {
		super(x, y, player);
	}

	public boolean isValid(int nX, int nY) {
		int distX = Math.abs(x - nX);
		int distY = Math.abs(y - nY);

		if (distX == distY || distX == 0 || distY == 0)
			return true;
		return false;
	}
}

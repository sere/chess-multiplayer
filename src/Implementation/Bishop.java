package Implementation;

/**
 *
 * @author serena
 */
public class Bishop extends Piece {

	Bishop(int x, int y, int player) {
		super(x, y, player);
	}

	public boolean isValid(int nX, int nY) {
		int distX = Math.abs(x - nX);
		int distY = Math.abs(y - nY);

		if (distX == distY)
			return true;
		return false;
	}
}

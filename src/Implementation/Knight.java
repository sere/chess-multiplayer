package Implementation;

/**
 *
 * @author serena
 */
public class Knight extends Piece {

	Knight(int x, int y, int player) {
		super(x, y, player);
	}

	public boolean isValid(int nX, int nY) {
		int distX = Math.abs(x - nX);
		int distY = Math.abs(y - nY);
		if ((distX == 1 && distY == 2) || (distX == 2 && distY == 1))
			return true;
		return false;
	}
}

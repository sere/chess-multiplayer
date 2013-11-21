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
		if ((distY + distX) == 3)
			return true;
		return false;
	}
}

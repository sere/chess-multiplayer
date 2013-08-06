package Implementation;

/**
 *
 * @author serena
 */
public class Rook extends Piece {

	private boolean moved = false;

	Rook(int x, int y, int player) {
		super(x, y, player);
	}

	public boolean isValid(int nX, int nY) {
		int distX = Math.abs(x - nX);
		int distY = Math.abs(y - nY);

		if (distX == 0 || distY == 0)
			return true;
		return false;
	}

	public void move(int nX, int nY) {
		super.move(nX, nY);
		moved = true;
	}
}

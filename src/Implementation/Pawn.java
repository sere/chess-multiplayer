package Implementation;

/**
 *
 * @author serena
 */
public class Pawn extends Piece {

	public boolean firstMove = true;

	public Pawn(int x, int y, int player) {
		super(x, y, player);
	}

	public void move(int x, int y) {
		super.move(x, y);
		firstMove = false;
	}

	public boolean isValid(int nX, int nY) {
		if ((nX == x + player) && ((nY == y) || (Math.abs(nY - y) == 1))) {
			return true;
		}
		if (firstMove && nX == x + 2 * player) {
			return true;
		}
		System.out.println("nX, ny " + nX + " " + nY);
		return false;
	}
}

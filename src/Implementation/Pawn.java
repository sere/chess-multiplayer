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

	public boolean isValid(int nX, int nY, boolean pieceIsNull) {
		/* Normal movement */
		if ((nX == x + player) && (nY == y) && pieceIsNull)
			return true;
		/* Capture */
		if (Math.abs(nY - y) == 1 && !pieceIsNull)
			return true;
		/* Double (first) movement */
		if (firstMove && nX == x + 2 * player && pieceIsNull)
			return true;
		System.out.println("nX, ny " + nX + " " + nY);
		return false;
	}
}

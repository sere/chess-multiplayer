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
		/* Capture */
		if (nX == x + player && Math.abs(nY - y) == 1 && !pieceIsNull)
			return true;
		/* Vertical moves */
		if (nY == y && pieceIsNull) {
			/* Normal movement */
			if (nX == x + player)
				return true;
			/* Double (first) movement */
			if (firstMove && nX == x + 2 * player)
				return true;
		}
		return false;
	}
}

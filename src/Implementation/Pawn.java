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
		return true;
	}
}

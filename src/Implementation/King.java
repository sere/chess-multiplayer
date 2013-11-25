package Implementation;

/**
 *
 * @author serena
 */
public class King extends Piece {

	private boolean moved = false;

	King(int x, int y, int player) {
		super(x, y, player);
	}

	public boolean isValid(int nX, int nY) {
		int distX = Math.abs(x - nX);
		int distY = Math.abs(y - nY);

		if (distX > 1 || distY > 1)
			return false;
		return true;
	}

	public void move(int nX, int nY) {
		super.move(nX, nY);
		if (!moved)
			System.out.println("prima mossa");
		moved = true;
	}

}

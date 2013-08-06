package Implementation;

/**
 *
 * @author serena
 */
public class Battlefield {

	public Piece pieces[][] = new Piece[8][8];

	public Battlefield() {
		pieces[7][1] = new Knight(7, 1, Player.WHITE);
		pieces[7][6] = new Knight(7, 6, Player.WHITE);
		pieces[0][1] = new Knight(0, 1, Player.BLACK);
		pieces[0][6] = new Knight(0, 6, Player.BLACK);
		pieces[7][0] = new Rook(7, 0, Player.WHITE);
		pieces[7][7] = new Rook(7, 7, Player.WHITE);
		pieces[0][0] = new Rook(0, 0, Player.BLACK);
		pieces[0][7] = new Rook(0, 7, Player.BLACK);
		pieces[7][3] = new Queen(7, 3, Player.WHITE);
		pieces[0][3] = new Queen(0, 3, Player.BLACK);
		for (int i = 0; i < 8; i++) {
			pieces[6][i] = new Pawn(6, i, Player.WHITE);
			pieces[1][i] = new Pawn(1, i, Player.BLACK);
		}
	}

	/**
	 * this function controls if a determined move attempts to pass through an
	 * occupied slot. This MUST be called after the Piece.isValid function
	 *
	 * @param x
	 * @param y
	 * @param nX
	 * @param nY
	 * @return
	 */
	public boolean isPathOccupied(int x, int y, int nX, int nY) {
		int distX = Math.abs(x - nX);
		int distY = Math.abs(y - nY);

		/* exclude consecutive slot */
		if (distX <= 1 && distY <= 1) {
			return false;
		}
		/* exclude knight  */
		if ((distY + distX) == 3) {
			return false;
		}
		/* now the move must be diagonal or orthogonal */
		assert (distX == distY || (distX == 0 || distY == 0));

		int minX = Math.min(x, nX);
		int minY = Math.min(y, nY);

		if ((x - nX) * (y - nY) < 0) {
			/* x and y discordant: only diagonal */
			for (int i = 1; i < distY; i++) {
				if (pieces[minX + i][Math.max(y, nY) - i] != null) {
					return true;
				}
			}
			return false;
		} else if ((x - nX) * (y - nY) > 0) {
			/* x and y concordant: only diagonal */
			for (int i = 1; i < Math.max(distX, distY); i++) {
				if (pieces[minX + i][minY + i] != null) {
					return true;
				}
			}
			return false;
		} else {
			/* orthogonal movements */
			if (distX == 0) {
				for (int i = 1; i < distY; i++) {
					if (pieces[x][minY + i] != null) {
						return true;
					}
				}
				return false;
			} else //distY == 0
			{
				for (int i = 1; i < distX; i++) {
					if (pieces[minX + 1][y] != null) {
						return true;
					}
				}
				return false;
			}
		}
	}

	public boolean isNull(int x, int y) {
		if (pieces[x][y] == null) {
			return true;
		}
		return false;
	}

	public int player(int x, int y) {
		return pieces[x][y].player;
	}

	public boolean move(int player, int x, int y, int nX, int nY) {
		if (pieces[nX][nY] != null && pieces[nX][nY].player == player) {
			System.out.println("illegal move; you can't eat you own pieces");
			return false;
		}

		if (!pieces[x][y].isValid(nX, nY)) {
			System.out.println("illegal: out of range for the Piece");
			return false;
		}

		if (isPathOccupied(x, y, nX, nY)) {
			System.out.println("This piece is trying to leap!!");
			return false;
		}

		pieces[x][y].move(nX, nY);
		pieces[nX][nY] = pieces[x][y];
		pieces[x][y] = null;
		return true;
	}
}

package Implementation;

import java.awt.Point;
import java.lang.Math.*;

/**
 *
 * @author serena
 */
public abstract class Piece {

	public int player;
	protected int x, y;

	public Piece(int x, int y, int player) {
		this.player = player;
		this.x = x;
		this.y = y;
	}

	public boolean isValid(int nX, int nY) {
		return true;
	}

	public boolean isValid(int nX, int nY, boolean piece) {
		return this.isValid(nX, nY);
	}

	public void move(int nX, int nY) {
		x = nX;
		y = nY;
	}

	public boolean canEat(int nX, int nY) {
		return true;
	}
}

package Implementation;

import java.awt.Point;
import java.lang.Math.*;

/**
 *
 * @author serena
 */
public abstract class Piece {

	public int player;
	public int x, y;

	public Piece(int x, int y, int player) {
		this.player = player;
		this.x = x;
		this.y = y;
	}

	public abstract boolean isValid(int nX, int nY);

	public void move(int nX, int nY) {
		x = nX;
		y = nY;
	}
}

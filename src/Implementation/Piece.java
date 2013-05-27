package Implementation;

import java.awt.Point;
import java.lang.Math.*;

/**
 *
 * @author serena
 */
public class Piece {

	public enum c {
		WHITE, BLACK
	};
	public c player;

	public Piece(c player) {
		this.player = player;
	}

	/*
	 * This assumes that src and dest represent different squares
	 * Two squares are diagonal if they differ of the same amount.
	 * That is, if one of the two is identified from (i,j), the other must
	 * be ((i+-k),(j+-k)). This implies that the absolute difference of the two
	 * must be equal.
	 */
	public boolean isDiag(Point src, Point dest) {
		// TODO private inline
		int i = (int) (src.getX() - dest.getX());
		int j = (int) (src.getY() - dest.getY());

		if ((int) Math.abs(i) != (int) Math.abs(j)) {
			return false;
		}

		return true;
	}

	/*
	 * This assumes that src and dest represent different squares
	 * Two squares are "on the same line" if one of the two coordinates is
	 * fixed.
	 */
	public boolean isOrt(Point src, Point dest) {
		int i = (int) Math.abs(src.getX() - dest.getX());
		int j = (int) Math.abs(src.getY() - dest.getY());

		return (i == 0 || j == 0);
	}

	/*
	 * This is necessary for handling the collisions and the captures.
	 * It returns true if the considered piece belongs to the opponent
	 */
	public boolean isOtherPlayer(c other) {
		return (this.player != other);
	}

	/* FIXME this must be a global flag indicating the turn */
	public c PLAYER = c.WHITE;

	public boolean isClickable() {
		return (this.player != PLAYER);
	}

	public boolean isPossible() {
		return false;
	}

	public boolean isValid() {
		return false;
	}
}

package Implementation;

/**
 *
 * @author serena
 */
public class Pawn extends Piece {
    public Pawn(c player) {
        super(player);
    }

    public boolean isPossible() {
        return true;
    }

    public boolean isValid() {
        return true;
    }
}

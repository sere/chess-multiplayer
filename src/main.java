import java.awt.Dimension;

import javax.swing.JFrame;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame board = new JFrame();
		ChessBoard cboard = new ChessBoard();
		board.setMinimumSize(new Dimension(200,200));
		board.add(cboard);
		board.setVisible(true);
	}

}

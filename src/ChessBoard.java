
import Implementation.Battlefield;
import Implementation.Pawn;
import Implementation.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ChessBoard extends JPanel {

	int N = 8;
	int dim = 400;
	public boolean somethingClicked;
	private int turn;
	private Battlefield battlefield;
	Square squares[][] = new Square[N][N];
	Square first, second;

	public ChessBoard() {

		GridLayout layout = new GridLayout();
		layout.setColumns(8);
		layout.setRows(8);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i + j) % 2 == 0) {
					squares[i][j] = new Square(Color.white, i, j, this);
					this.add(squares[i][j]);
				} else {
					squares[i][j] = new Square(Color.black, i, j, this);
					this.add(squares[i][j]);
				}
			}
		}

		this.startMatch();
		this.setPreferredSize(new Dimension(dim, dim));
		this.setLayout(layout);
		this.setVisible(true);
	}

	public void startMatch() {
		battlefield = new Battlefield();
		turn = Player.WHITE;
		squares[7][1].setImagePath("images/wknight.gif");
		squares[7][6].setImagePath("images/wknight.gif");
		squares[0][1].setImagePath("images/bknight.gif");
		squares[0][6].setImagePath("images/bknight.gif");
		for (int i = 0; i < 8; i++) {
			squares[6][i].setImagePath("images/wpawn.gif");
			squares[1][i].setImagePath("images/bpawn.gif");
		}
	}

	public void moveSelection(Square square) {
		if (!somethingClicked) {
			//System.out.println("first");

			first = square;
			if (battlefield.isNull(first.x, first.y)) {
				System.out.println("null!!!");
				return;
			}
			if (battlefield.player(first.x, first.y) != turn) {
				System.out.println("move your pieces not the other's!!");
				return;
			}
			first.setBackground(Color.red);

			somethingClicked = true;
		} else {
			//System.out.println("second");

			Graphics g = first.getGraphics();
			second = square;

			if (first.x == second.x && first.y == second.y) {
				System.out.println("deselect square");
				/* redundant code due to lack of goto statement */
				first.setBackground(first.bg_color);
				somethingClicked = false;
				first = null;
				second = null;
				return;
			}

			if (!battlefield.move(turn, first.x, first.y, second.x, second.y)) {
				System.out.println("move not valid");
				return;
			}
			this.move();

			first.setBackground(first.bg_color);

			if (turn == Player.WHITE) {
				turn = Player.BLACK;
			} else {
				turn = Player.WHITE;
			}
			System.out.println("turn of " + turn);
			somethingClicked = false;
			first = null;
			second = null;
		}
	}

	public void move() {
		System.out.println("move");

		second.setImage(first.getImage());
		first.setImage(null);

		second.paintComponent(second.getGraphics());
		first.paintComponent(first.getGraphics());

	}
}

package Graphic;

import Implementation.Battlefield;
import Implementation.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChessBoard extends JPanel {

	public static int PLAYER;
	private int N = 8;
	private int dim = 400;
	private boolean somethingClicked;
	private int turn;
	private Battlefield battlefield;
	private Square squares[][] = new Square[N][N];
	private Square first, second;

	public ChessBoard() {

		GridLayout layout = new GridLayout();
		layout.setColumns(8);
		layout.setRows(8);

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if ((i + j) % 2 == 0) {
					squares[i][j] = new Square(Color.white, i, j, this);
					this.add(squares[i][j]);
				} else {
					squares[i][j] = new Square(Color.black, i, j, this);
					this.add(squares[i][j]);
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
		squares[7][0].setImagePath("images/wrook.gif");
		squares[7][7].setImagePath("images/wrook.gif");
		squares[0][0].setImagePath("images/brook.gif");
		squares[0][7].setImagePath("images/brook.gif");
		squares[7][3].setImagePath("images/wqueen.gif");
		squares[0][3].setImagePath("images/bqueen.gif");
		squares[7][4].setImagePath("images/wking.gif");
		squares[0][4].setImagePath("images/bking.gif");
		squares[7][2].setImagePath("images/wbishop.gif");
		squares[7][5].setImagePath("images/wbishop.gif");
		squares[0][2].setImagePath("images/bbishop.gif");
		squares[0][5].setImagePath("images/bbishop.gif");
		for (int i = 0; i < 8; i++) {
			squares[6][i].setImagePath("images/wpawn.gif");
			squares[1][i].setImagePath("images/bpawn.gif");
		}
	}

	public void moveSelection(Square square) {
		if (!somethingClicked) {
			/* Check if the square is a piece of the actual player and select
			 * it if true.
			 */
			first = square;
			if (battlefield.isNull(first.x, first.y)) {
				System.out.println("null!!!");
				return;
			}
			if (battlefield.player(first.x, first.y) != PLAYER) {
				System.out.println("illegal: not your piece");
				return;
			}
			if (battlefield.player(first.x, first.y) != turn) {
				System.out.println("illegal: not your turn");
				return;
			}

			first.setBackground(Color.red);
			somethingClicked = true;
		} else {
			second = square;
			/* Check if the player wants to change piece */
			if (first.x == second.x && first.y == second.y) {
				System.out.println("deselect square");
				resetSelection();
				return;
			}
			/* Move the piece from first to second */
			if (!battlefield.move(turn, first.x, first.y, second.x, second.y)) {
				System.out.println("move not valid");
				return;
			}
			this.move();

			/* Conclude the turn */
			resetSelection();
			if (turn == Player.WHITE)
				turn = Player.BLACK;
			else
				turn = Player.WHITE;
			System.out.println("turn of " + turn);
		}
	}

	private void resetSelection() {
		first.setBackground(first.bg_color);
		somethingClicked = false;
		first = null;
		second = null;
	}

	private void move() {
		System.out.println("Graphic.move");

		second.setImage(first.getImage());
		first.setImage(null);

		second.paintComponent(second.getGraphics());
		first.paintComponent(first.getGraphics());

	}
}

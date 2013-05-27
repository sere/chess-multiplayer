
import Implementation.Pawn;
import Implementation.Piece.c;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ChessBoard extends JPanel {

	int N = 8;
	int dim = 400;
	public boolean somethingClicked;
	private c turn;
	Square squares[][] = new Square[N][N];
	Square first, second;

	public ChessBoard() {

		GridLayout layout = new GridLayout();
		layout.setColumns(8);
		layout.setRows(8);

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
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
		turn = c.WHITE;
		for (int i = 0; i < 8; i++) {
			squares[i][6].setImagePath("images/wpawn.gif");
			squares[i][6].setPiece(new Pawn(c.WHITE));
			squares[i][1].setImagePath("images/bpawn.gif");
			squares[i][1].setPiece(new Pawn(c.BLACK));
		}
	}

	public void moveSelection(Square square) {
		if (!somethingClicked) {
			//System.out.println("first");

			first = square;
			if(first.getPiece() == null) {
				System.out.println("null!!!");
				return;
			}
			if(first.getPiece().player != turn) {
				System.out.println("move your pieces not the other's!!");
				return;
			}
			first.setBackground(Color.red);

			somethingClicked = true;
		} else {
			//System.out.println("second");

			Graphics g = first.getGraphics();
			second = square;

			if(second.getPiece() != null && second.getPiece().player == turn) {
				System.out.println("illegal move; you can't eat you own pieces");
				return;
			}

			this.move();

			first.setBackground(first.bg_color);

			if (turn == c.WHITE)
				turn = c.BLACK;
			else
				turn = c.WHITE;
			System.out.println("turn of "+ turn);
			somethingClicked = false;
			first = null;
			second = null;
		}
	}

	public void move() {
		System.out.println("move");

		second.setImage(first.getImage());
		second.setPiece(first.getPiece());

		first.setImage(null);
		first.setPiece(null);
		second.paintComponent(second.getGraphics());
		first.paintComponent(first.getGraphics());

	}
}

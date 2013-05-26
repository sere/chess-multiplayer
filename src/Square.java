import Implementation.Piece;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.*;


public class Square extends JPanel implements MouseListener {

	private int x;
	private int y;
	private ChessBoard chessboard;
	public Color bg_color;
	private String imagePath;
	private Image image;
	private MediaTracker m;
	private Toolkit t;
	private Piece piece;

	public Square(Color c, int x, int y, ChessBoard ci) {
		super();
		bg_color = c;
		chessboard = ci;
		this.x = x;
		this.y = y;
		this.setBackground(bg_color);
		this.addMouseListener(this);
		this.setVisible(true);
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		t = Toolkit.getDefaultToolkit();
		image = t.getImage(imagePath);
		m = new MediaTracker(this);
		m.addImage(image, 1);
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		/*** This is only for debugging purpose ***/
		int pos = x + y * 8;
		g.setColor(Color.red);
		String s = String.valueOf(pos);
		g.drawString(s, 10, 10);

		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.finalize();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		chessboard.moveSelection(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}

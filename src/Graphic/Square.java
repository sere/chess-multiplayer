package Graphic;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Square extends JPanel implements MouseListener {

	public int x;
	public int y;
	private ChessBoard chessboard;
	public Color bg_color;
	private String imagePath;
	private Image image;
	private MediaTracker m;
	private Toolkit t;

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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		/**
		 * * This is only for debugging purpose **
		 */
		g.setColor(Color.red);
		String s = String.valueOf(x);
		g.drawString(s, 8, 10);
		s = String.valueOf(y);
		g.drawString(s, 16, 10);

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

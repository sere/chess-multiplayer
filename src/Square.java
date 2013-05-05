import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;


public class Square extends JPanel {
	private int pos;
        String image;
        Image piece;
        MediaTracker m;
        Toolkit t;
               
        public Square(Color c, int pos){
		super();
                this.pos=pos;
		this.setBackground(c);
		//int n = 80;
		//this.setMinimumSize(new Dimension(n,n));
                this.setVisible(true);
	}

        public void setImage(String image) {
                this.image = image;
                t= Toolkit.getDefaultToolkit();
                piece = t.getImage(image);
                m = new MediaTracker(this);
                m.addImage(piece, 1); 
        }
        
        
	public void paintComponent(Graphics g2) {
                Graphics2D g = (Graphics2D) g2;
		super.paintComponent(g);
		
                /**** This is only for debugging purpose ****/
                g.setColor(Color.red);
		String s = String.valueOf(pos);
                g.drawString(s, 10, 10);
                
        
                g.drawImage(piece, 0, 0, this.getWidth(), this.getHeight(), this);
                g.finalize();
	}
}


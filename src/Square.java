import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;


public class Square extends JPanel {
	public Square(Color c){
		super();
		this.setBackground(c);
		//this.setOpaque(true);
		this.setMinimumSize(new Dimension(50,50));
		this.setVisible(true);
	}
}

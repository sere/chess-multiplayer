import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class ChessBoard extends JPanel {
	int N = 64;
	Square square [] = new Square[N];
	
	public ChessBoard() {
		// created from the top left corner
		for (int i = 0; i < N; i+=2)
			square[i] = new Square(Color.white);
		for (int i = 1; i < N; i+=2)
			square[i] = new Square(Color.black);
		
		
		GridLayout layout = new GridLayout(); //righe e colonne
		layout.setColumns(8);
		layout.setRows(8);
		for (int i=0; i<N; i++)
			this.add(square[i]);
		this.setLayout(layout);
		this.setVisible(true);
	}
	
	public void draw() {
		//super.draw();
		GridLayout layout = new GridLayout(8,8); //righe e colonne
		this.add(square[1]);
		this.setLayout(layout);
		this.setVisible(true);
	}
}

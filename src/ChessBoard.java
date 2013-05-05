import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ChessBoard extends JPanel {
	int N = 8;
	int dim = 400;
	Square squares[][] = new Square[N][N];

	public ChessBoard() {
		
		GridLayout layout = new GridLayout(); // righe e colonne
		layout.setColumns(8);
		layout.setRows(8);
		
		for (int j = 0; j < N; j++)
			for (int i = 0; i < N; i++)
				if ((i + j) % 2 == 0){
					squares[i][j] = new Square(Color.white, i+j*8);
					this.add(squares[i][j]);
					}
				else {
					squares[i][j] = new Square(Color.black, i+j*8);
					this.add(squares[i][j]);
					}

                this.startMatch();
		this.setPreferredSize(new Dimension(dim,dim));
		this.setLayout(layout);
		this.setVisible(true);
	}

        public void startMatch(){
            for (int i = 0; i < 8; i++) {
                squares[i][6].setImage("images/wpawn.gif");
                squares[i][1].setImage("images/bpawn.gif");
            }
        }
	
}

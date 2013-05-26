import javax.swing.*;
import java.awt.event.*;

public class Side extends JPanel{
	public Side(){
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("Inizio Partita");
		//quando aggiungiamo le azioni, aggiungiamo una label
		JButton newgame = new JButton("New");
		JButton quitgame = new JButton("Quit");

		newgame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
			//scrivere cosa fa per creare una nuova partita
			}
		});

		quitgame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
			//scrivere cosa fa per chiudere la partita
			}
		});


		this.add(label);
		this.add(newgame);
		this.add(quitgame);

		this.setLayout(layout);
		this.setVisible(true);
	}
}

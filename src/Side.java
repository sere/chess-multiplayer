import javax.swing.*;
import java.awt.event.*;

public class Side extends JPanel{
	public Side(){
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("Inizio Partita");
		//when we'll add moves, we'll add a new label
		JButton newgame = new JButton("New");
		JButton quitgame = new JButton("Quit");

		newgame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
					String titleConfirm = "Wait!";
					String messageConfirm = "Are you sure you want to start a new game?";
					int confirmQuit = JOptionPane.showConfirmDialog(null, messageConfirm, titleConfirm, JOptionPane.OK_CANCEL_OPTION);
					if (confirmQuit != JOptionPane.OK_OPTION){
						return;
					}
			//write code to start a new match
			}
		});

		quitgame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				String titleConfirm = "Wait!";
				String messageConfirm = "Are you sure you want to quit?";
				int confirmQuit = JOptionPane.showConfirmDialog(null, messageConfirm, titleConfirm, JOptionPane.OK_CANCEL_OPTION);
				if (confirmQuit != JOptionPane.OK_OPTION){
					return;
				}
			//write code to quit the game
			}
		});


		this.add(label);
		this.add(newgame);
		this.add(quitgame);

		this.setLayout(layout);
		this.setVisible(true);
	}
}

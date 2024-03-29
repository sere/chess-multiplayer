package Graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Side extends JPanel {

	Wind windy;

	public Side() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		JLabel label = new JLabel("Inizio Partita");
		//when we'll add moves, we'll add a new label
		JButton newgame = new JButton("New");
		JButton quitgame = new JButton("Quit");

		newgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String titleConfirm = "Wait!";
				String messageConfirm = "Are you sure you want to start a new game?";
				int confirmQuit = JOptionPane.showConfirmDialog(null, messageConfirm, titleConfirm, JOptionPane.OK_CANCEL_OPTION);
				if (confirmQuit != JOptionPane.OK_OPTION)
					return;
				//FIXME:check if it's good even when there will be 2 players involved
				windy.setVisible(false);
				windy.dispose();
				new Wind();
			}
		});

		quitgame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e2) {
				String titleConfirm = "Wait!";
				String messageConfirm = "Are you sure you want to quit?";
				int confirmQuit = JOptionPane.showConfirmDialog(null, messageConfirm, titleConfirm, JOptionPane.OK_CANCEL_OPTION);
				if (confirmQuit != JOptionPane.OK_OPTION)
					return;
				windy.setVisible(false);
				windy.dispose();
				new net.StartWind();
			}

		});

		this.add(label);
		this.add(newgame);
		this.add(quitgame);

		this.setLayout(layout);
		this.setVisible(true);
	}

	public void setWindow(Wind window) {
		windy = window;
	}
}

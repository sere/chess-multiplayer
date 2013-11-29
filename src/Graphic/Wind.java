package Graphic;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Wind extends JFrame {
	static Container c = new Container();
	public Wind() {
		c = this.getContentPane();
		//BoxLayout box = new BoxLayout(c, BoxLayout.Y_AXIS);
		BoxLayout box = new BoxLayout(c, BoxLayout.X_AXIS);
		//JPanel panel = new JPanel();
		//BoxLayout minibox = new BoxLayout(panel, BoxLayout.X_AXIS);
		ChessBoard cboard = new ChessBoard();
		//FIXME: i want to move this MinimumSize to the ChessBoard object
		this.setMinimumSize(new Dimension(20, 20));
		Side cside = new Side();
		cside.setWindow(this);
		JMenuBar cbar = createMenu();
		//panel.add(cboard);
		//panel.add(cside);
		//panel.setLayout(minibox);

		c.add(cboard);
		c.add(cside);

		this.setJMenuBar(cbar);
		//c.add(panel);

		this.setLayout(box);
		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JMenuBar createMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu exitall = new JMenu("Exit");
		JMenu help = new JMenu("Help");
		JMenuItem iexit = new JMenuItem("Exit");
		JMenuItem ihelp = new JMenuItem("?");
		JMenuItem icredits = new JMenuItem("Credits");
		
		exitall.add(iexit);
		help.add(ihelp);
		help.add(icredits);
		bar.add(exitall);
		bar.add(help);
		
		return bar;
	}

	public void closeWind(ActionEvent e){
		this.setVisible(false);
		this.dispose();
		System.exit(0);
	}
}

package Graphic;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Wind extends JFrame {
	static Container c = new Container();
	public Wind() {
		this.setTitle("Chess");
		c = this.getContentPane();
		BoxLayout box = new BoxLayout(c, BoxLayout.X_AXIS);
		ChessBoard cboard = new ChessBoard();
		//FIXME: i want to move this MinimumSize to the ChessBoard object
		this.setMinimumSize(new Dimension(20, 20));
		Side cside = new Side();
		cside.setWindow(this);
		JMenuBar cbar = createMenu();

		c.add(cboard);
		c.add(cside);

		this.setJMenuBar(cbar);

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
		
		iexit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
				exit();
			}
		});
		
		ihelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				help();
			}
		});
		
		icredits.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				credits();
			}
		});
		
		exitall.add(iexit);
		help.add(ihelp);
		help.add(icredits);
		bar.add(exitall);
		bar.add(help);
		
		return bar;
	}

	private void exit(){
		this.setVisible(false);
		this.dispose();
		System.exit(0);
	}
	
	private void help(){
		JFrame fhelp = new JFrame("Help");
		//FIXME: we should really consider to put something relevant here
		String text = "This is the help panel. \n"+
		"Here we should write the help.";
		JTextArea thelp = new JTextArea(text);
		fhelp.add(thelp);
		fhelp.pack();
		fhelp.setVisible(true);
	}
	
	private void credits(){
		JFrame fcred = new JFrame("Credits");
		//FIXME: we should really consider to put something relevant here
		String text = "This is the credit panel. \n"+
		"Here we should write the credits.";
		JTextArea tcred = new JTextArea(text);
		fcred.add(tcred);
		fcred.pack();
		fcred.setVisible(true);
	}
}

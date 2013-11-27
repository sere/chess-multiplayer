package net;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartWind extends JFrame{
	boolean isServer;
	boolean isClicked=false;
	public StartWind(){
		Container c = new Container();
		c = this.getContentPane();
		BoxLayout box = new BoxLayout(c, BoxLayout.Y_AXIS);
		this.setMinimumSize(new Dimension(20,20));
		JButton startnew = new JButton("Start a new game");
		JButton join = new JButton("Join existing game");
		startnew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
				new SerWind();
				closeWindow();
			}
		});
		join.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				new CliWind();
				closeWindow();
			}
		});
		
		c.add(startnew);
		c.add(join);
		
		this.setLayout(box);
                this.pack();
		this.setVisible(true);
                
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void closeWindow(){
		this.setVisible(false);
		this.dispose();
		}
}

package net;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.*;

@SuppressWarnings("serial")
public class CliWind extends JFrame{

	public CliWind(){
		this.setTitle("Chess");
		Container c = new Container();
		c = this.getContentPane();
		BoxLayout box = new BoxLayout(c, BoxLayout.Y_AXIS);
		this.setMinimumSize(new Dimension(50,50));
		JButton ok = new JButton("Set address");
		JButton cancel = new JButton("Cancel");
		JLabel address = new JLabel("address");
		JLabel port= new JLabel("port");
		NumberFormat num = NumberFormat.getInstance();
		num.setGroupingUsed(false);
		num.setParseIntegerOnly(true);
		num.setMaximumIntegerDigits(4);
		final JTextField cliport = new JTextField();
		
		
		NumberFormat num2 = NumberFormat.getInstance();
		num2.setGroupingUsed(false);
		num2.setParseIntegerOnly(true);
		num2.setMaximumIntegerDigits(3);
		final JTextField ipaddress = new JTextField();
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
				boolean again = true;
				while(again){
					int portnumber=Integer.parseInt(cliport.getText());
					String addr = ipaddress.getText();
					if (portnumber>1024 && portnumber<65535)
						again = false;
					else
						System.out.println("Error: invalid port number");
					
				
					Connect.ClientConnection(addr, portnumber);
					closeWindow();
				}
			}
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				new StartWind();
				closeWindow();
			}
		});
		this.add(address);
		this.add(ipaddress);
		this.add(port);
		this.add(cliport);
		this.add(ok);
		this.add(cancel);
		
		this.setLayout(box);
        this.pack();
		this.setVisible(true);
                
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}
	
	public void closeWindow(){
	this.setVisible(false);
	this.dispose();
	}
}

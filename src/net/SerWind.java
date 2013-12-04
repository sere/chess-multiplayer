package net;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import net.Connecting;

@SuppressWarnings("serial")
public class SerWind extends JFrame {

	int portnum;
	Container c;
	JButton ok;
	JButton cancel;
	JLabel portlabel;
	JLabel ipaddr;
	JTextField port;
	StartThread t = new StartThread();

	public SerWind() {
		this.setTitle("Chess");
		String ip = null;
		c = new Container();
		c = this.getContentPane();
		BoxLayout box = new BoxLayout(c, BoxLayout.Y_AXIS);
		this.setMinimumSize(new Dimension(50, 50));
		ok = new JButton("Set port");
		cancel = new JButton("Cancel");
		portlabel = new JLabel("Port:");
		port = new JTextField();
		//Find out my IP address
		try {
			URL whatismyip = new URL("http://api.externalip.net/ip/");
			BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
			ip = in.readLine();
		} catch (Exception e) {
		};
		ipaddr = new JLabel("Your IP is: " + ip);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
					portnum = Integer.parseInt(port.getText());
				} catch (Exception ex) {
					portnum = 8080;
				};
				//controllo numero porta !ricordarsi di toglierlo
				System.out.println(portnum);
				if (portnum < 1024 || portnum > 65535) {
					portnum = 8080;
					System.out.println(portnum);
				}
				try {
					waitOpponent();
				} catch (IOException e) {
					System.out.println("Error e-Server: connect");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				restartWindow();
			}
		});

		c.add(ipaddr);
		c.add(portlabel);
		c.add(port);
		c.add(ok);
		c.add(cancel);

		this.setLayout(box);
		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/*public void connect(int port) throws IOException{
	 *	this.setVisible(false);
	 *	new Connecting(port);
	 *	this.dispose();
	 *}
	 */
	private void waitOpponent() throws IOException, InterruptedException {
		JLabel waiting = new JLabel("Waiting opponent...");
		JButton undo = new JButton("Cancel");

		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				t.alt();
				restartWindow();
			}
		});
		c.removeAll();
		c.add(waiting);
		c.add(undo);

		this.pack();
		this.repaint();
		t.run(portnum);
		t.join();

		closeWindow();
	}

	private void restartWindow() {
		this.setVisible(false);
		new StartWind();
		this.dispose();
	}

	private void closeWindow() {
		this.setVisible(false);
		this.dispose();
	}
}

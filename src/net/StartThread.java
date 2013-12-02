package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Graphic.Wind;

public class StartThread extends Thread{
	private static ServerSocket welcomeSocket;
	private static Socket connectionSocket;
	boolean stop;
	public void run(int portnum){
		stop=false;
			stop=ServerConnection(portnum);
		return;
		}
	
	private static boolean ServerConnection(int port){
		boolean connected=false;
		boolean screated=false;
		try{
			screated=Connect.StartServer(port);
		}
		catch(Exception ex){
			System.err.println("Error during the server creation");
			return false;
		}
		if(!screated)
			return false;
		try{
			while(connected){
			connectionSocket = welcomeSocket.accept();
			connected=connectionSocket.isBound();
				}
			}
			catch(Exception ex1){
				ex1.printStackTrace();
				System.out.println("Error ex1-Connection: Connection Socket fail");
				return false;
			}
			new Wind();
			return(connected);
		
	}
	
	public static void stopConnection() throws IOException{
		connectionSocket.close();
	}
		
	public void alt(){
		stop=true;
		}
}

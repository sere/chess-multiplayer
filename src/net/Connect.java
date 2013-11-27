package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Implementation.*;


public class Connect{
		private static ServerSocket welcomeSocket;
		private static Socket connectionSocket;
		static SerWind srvrwind;

		public static boolean ServerConnection(int port){
			boolean screated=false;
			try{
				screated=StartServer(port);
			}
			catch(Exception ex){
				System.err.println("Error during the server creation");
				return false;
			}
			if(!screated)
				return false;
			try{
				connectionSocket = welcomeSocket.accept();
			}
			catch(Exception ex1){
				ex1.printStackTrace();
				System.out.println("Error ex1-Connection: Connection Socket fail");
				return false;
			}
			new Battlefield();
			//dovrei importare Window dal default package ma siccome non ci riesco per adesso commento
			//new Window();
			if(connectionSocket.isBound())
				return true;
			else
				return false;
			
		}
		public static boolean StartServer(int portnum){
			try{
				welcomeSocket = new ServerSocket(portnum);
			}
			catch (IOException ex2){
				System.out.println("Error ex2-Connection:Welcome Socket fail");
				return false;
			}
			System.out.println("Server creato consuccesso!");
			return true;
		}
		
		public static void ClientConnection(String ipadd, int port){
			try{
			connectionSocket = new Socket(ipadd, port);
			}
			catch(IOException ex3){
				ex3.printStackTrace();
				System.out.println("Error ex3-Connection: Connection Socket fail");
				return;
			}
			//dovrei importare Window dal default package ma siccome non ci riesco per adesso commento
			//new Window();
		}
		
		public static void stopConnection() throws IOException{
			connectionSocket.close();
		}
}

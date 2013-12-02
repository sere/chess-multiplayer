package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Connect{
		private static Socket connectionSocket;
		static SerWind srvrwind;

		public static boolean StartServer(int portnum){
			try{
				new ServerSocket(portnum);
			}
			catch (IOException ex2){
				System.out.println("Error ex2-Connection:Welcome Socket fail");
				return false;
			}
			System.out.println("Server created successfully!");
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
		}
		
		public static void stopConnection() throws IOException{
			connectionSocket.close();
		}
}

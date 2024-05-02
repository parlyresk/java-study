package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {

	public static final int PORT = 8888;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			log("starts....[port:" + PORT + "]");
			List<PrintWriter> listWriters=new ArrayList<>();
			while(true) {
				Socket socket = serverSocket.accept();  // blocking
				
				new ChatServerThread(socket, listWriters).start();
			}
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void log(String message) {
		System.out.println("[ChatServer] " + message);
	}

}

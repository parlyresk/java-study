package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Encoder;

import chat.ChatServer;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private static final String SERVER_IP = "127.0.0.1";
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	public String nickname;
	private boolean running=true;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		socket = new Socket();
		nickname=name;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		// IOSTream 받아오기
		
		// ChatClientThread 생성
        try {
        	socket=new Socket();
        	socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
        	
        	pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            
            
            byte[] targetBytes = nickname.getBytes();
            Encoder encoder = Base64.getEncoder();
            byte[] encodedBytes = encoder.encode(targetBytes);
   
            pw.println("join:"+new String(encodedBytes));
            textArea.append("환영합니다!"+nickname+"님! 즐거운 채팅하세요!\n");
            
            new ChatClientThread().start();
            
        }catch(IOException e) {
        	System.out.println("error 01");
        	e.printStackTrace();
        }
	}

	private void sendMessage() {
		String message = textField.getText();
		if("quit".equals(message)) {
			pw.println("quit:" + message);
			finish();
		}else {
			
			byte[] targetBytes = message.getBytes();
			Encoder encoder = Base64.getEncoder();
            byte[] encodedBytes = encoder.encode(targetBytes);
			pw.println("message:" + new String(encodedBytes));
			
		}

		textField.setText("");
		textField.requestFocus();

		
		
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		running=false;
		
		try {
			// 10. 자원정리

			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
			if (pw != null) {
				pw.close();
			}
			if (br != null) {
				br.close();
			}
		} catch (IOException e) {
			System.out.println("error 02");
			e.printStackTrace();
		}
		// exit java application
		System.exit(0);
	}

	private class ChatClientThread extends Thread {
		

	    
		@Override
		public void run() {
			try {
				String message;
				while (running && (message = br.readLine()) != null) {
					updateTextArea(message);
				}

			} catch (IOException e) {
				if (running) {
	                System.out.println("정상적이지 못한 종료");
	                e.printStackTrace();
	            }
			}

		}
	}
}
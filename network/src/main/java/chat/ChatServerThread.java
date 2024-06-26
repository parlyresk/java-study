package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<PrintWriter> listWriters = new ArrayList<>();

	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		PrintWriter pw = null;
		try {
			// stream 얻기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			while (true) {
				String request = br.readLine();
				if (request == null) {
					ChatServer.log("클라이언트로부터 연결 끊김");
					doQuit(pw);
					break;
				}

				// 프로토콜 분석
				String[] tokens = request.split(":");
				Decoder decoder = Base64.getDecoder();
		        byte[] decodedBytes = decoder.decode(tokens[1]);
				if ("join".equals(tokens[0])) {
					
			        
					doJoin(new String(decodedBytes), pw);
				} else if ("message".equals(tokens[0])) {
					
					
					doMessage(new String(decodedBytes));
					
					
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				} else {
					ChatServer.log("에러: 알 수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch (IOException e) {
			doQuit(pw);
			
			ChatServer.log("클라이언트 통신 오류: " + e);
		}
	}

	private void doJoin(String nickName, PrintWriter pw) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);

		// writer pool에 저장
		addWriter(pw);

		// ack
		//pw.println("join:ok:" + nickName);
	}

	private void doQuit(PrintWriter pw) {
		
		removeWriter(pw);

		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
		
	}

	private void removeWriter(PrintWriter pw) {
		// 구현
		synchronized (listWriters) {
			listWriters.remove(pw);
		}
	}

	private void doMessage(String message) {
		// TODO Auto-generated method stub
		String data = nickname + ":" + message;
		broadcast(data);
	}

	private void addWriter(PrintWriter pw) {
		synchronized (listWriters) {
			listWriters.add(pw);
		}
	}

	private void broadcast(String data) {
//		System.out.println(listWriters.size()+"사이즈 출력");
		synchronized (listWriters) {
        	
			for (PrintWriter pw : listWriters) {
				
				pw.println(">>" + data);

			}
		}
	}
}

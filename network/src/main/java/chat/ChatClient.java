package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;



public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {
        Scanner scanner = null;
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;

        try {
            // 1. 키보드 연결
            scanner = new Scanner(System.in);

            // 2. socket 생성
            socket = new Socket();

            // 3. 연결
            socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

            // 4. reader/writer 생성
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            // 5. join 프로토콜
            System.out.print("닉네임>> ");
            String nickname = scanner.nextLine();
            pw.println("join:" + nickname);
            

            // 6. ChatClientThread 시작
            
            new ChatClientThread(br).start();
            

            // 7. 키보드 입력 처리
            while (true) {
                
                String input = scanner.nextLine();

                if ("quit".equals(input)) {
                    // 8. quit 프로토콜 처리
                    pw.println("quit"+nickname);
                    
                    break;
                } else {
                    // 9. 메시지 처리
                    pw.println("message:" + input);
                    
                }
            }
        } catch (SocketException e) {
            log("Socket Exception: " + e);
        } catch (IOException e) {
            log("error:" + e);
        } finally {
            try {
                // 10. 자원정리
                if (scanner != null) {
                    scanner.close();
                }
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
                e.printStackTrace();
            }
        }
    }

    public static void log(String message) {
        System.out.println("[ChatClient] " + message);
    }
}

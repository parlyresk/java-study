package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			
			//1. 서버 소켓 생성
			serverSocket=new ServerSocket();
			
			//2. 바인딩(binding)
			//	 소켓에 InetSocketAddress(ip주소+port)를 합친다
			//	 IPAddress:0.0.0.0: 특정 호스트 IP를 바인딩하지 않고 전부 열어준다
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000),10);
			
			// 3. accept
			Socket socket = serverSocket.accept(); // blocking
			
			try {
				InetSocketAddress inetRemoteSocketAddress=(InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				
				System.out.println("[server] connected by client["+remoteHostAddress+":"+ remotePort +"]");
				
				//4 IO Stream 받아오기
				InputStream is =socket.getInputStream();
				OutputStream os=socket.getOutputStream();
				
				//5 데이터 읽기
				while(true) {
					byte[] buffer=new byte[256];
					int readByteCount = is.read(buffer);
					//클라이언트가 정상 종료(close()호출)
					
					if(readByteCount==-1) {
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer,0,readByteCount,"UTF-8");
					System.out.println("[server] received:" + data);
					
					
					//6 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
				
			}catch(SocketException e) {
				System.out.println("[server] suddenly closed:"+e);
				
			}
			
			catch(IOException e) {
				System.out.println("[server] error:"+e);
				
			}finally {
				try {
					if(socket!=null && !socket.isClosed()) {
						socket.close();
					}
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			
		} catch (IOException e) {
			System.out.println("[server] error: " + e);
		} finally {
			try {
				if(serverSocket!=null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
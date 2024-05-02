package chat;

import java.io.BufferedReader;
import java.io.IOException;


public class ChatClientThread extends Thread {
    private BufferedReader br;
    

    public ChatClientThread(BufferedReader br) {
        this.br = br;
        
    }

    @Override
    public void run() {
    	try {
    		while(true) {
    			String data=br.readLine();
    			
    			
    			if(data==null) {
    				ChatClient.log("서버로부터 닫혔습니다");
    				break;
    			}
    			String[] tokens = data.split(":");
    			if ("join".equals(tokens[0])) {
    				System.out.println("환영합니다!"+tokens[2]+"님! 즐거운 채팅하세요!");
    			}else {
    				System.out.println(data);
    			}
    			
    		}
    	}
    	catch(IOException e){
    		// quit하면 여기로 넘어가는데?
    		ChatClient.log("error12312321:" +e);
    	}
    }
}

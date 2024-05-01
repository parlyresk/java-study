package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		String string = "www.naver.com";
		InetAddress[] name;
		try {
			name = InetAddress.getAllByName(string);
			for(int i=0;i<name.length;i++) {
				System.out.println(name[i].getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner=null;
		while(true) {
			System.out.print(">");
			scanner=new Scanner(System.in);
			String string = scanner.next();
			if("exit".equals(string)) {
				break;
			}
			InetAddress[] name;
			try {
				name = InetAddress.getAllByName(string);
				for(int i=0;i<name.length;i++) {
					System.out.print(name[i].getHostName());
					System.out.println(" : " +name[i].getHostAddress());
				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		scanner.close();
	}

}

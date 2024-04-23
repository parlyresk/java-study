package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		String temp;
        for (int i=0;i<text.length() ;i++ ) {
            temp="";
            for (int j=0;j<=i ;j++ ) {
                char c = text.charAt(j);
                temp+=c;
                
            }
            System.out.println(temp);
        }
		
		scanner.close();
	}

}

package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] count= new int[10];

		/* 코드 작성 */
		System.out.print("금액:");
		int val=scanner.nextInt();
		
		for(int i=0;i<MONEYS.length;i++) {
			count[i]=(int)val/MONEYS[i];
			val-=count[i]*MONEYS[i];
		}
		for(int i=0;i<count.length;i++) {
			System.out.print(MONEYS[i]+"원:"+count[i]);
			System.out.println("개");
		}
		scanner.close();
		
 	}
}
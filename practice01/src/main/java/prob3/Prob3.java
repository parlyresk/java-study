package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("숫자를 입력하세요 : ");
        int num=scanner.nextInt();
        int sum=0;
        if(num%2==0){
           for (int i=2;i<=num ;i=i+2 ) {
               sum+=i;
           }
        }
        else{
            for (int i=1;i<=num ;i=i+2 ) {
                sum+=i;
            }
        }
        System.out.print("결과 값 : ");
        System.out.print(sum);
		
		scanner.close();
	}
}

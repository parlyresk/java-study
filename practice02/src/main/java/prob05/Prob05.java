package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			int start=1;
			int end=100;
			int count=1;
			while(true) {
				System.out.println(start + "-"+end);
				System.out.print(count+">>");
				count+=1;
				int ans=scanner.nextInt();
				if(correctNumber>ans) {
					System.out.println("더 높게");
					start=ans;
				}
				else if(correctNumber<ans) {
					System.out.println("더 낮게");
					end=ans;
				}
				else {
					System.out.println("맞았습니다.");
					break;
				}
			}

			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}
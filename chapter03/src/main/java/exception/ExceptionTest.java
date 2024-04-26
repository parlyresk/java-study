package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10-a;
		
		System.out.println(" Some Codes1...");
		try {
			System.out.println(" Some Codes2...");
			System.out.println(" Some Codes3...");
			int result=(1+2+3)/b;
			
			System.out.println(" Some Codes4...");
			System.out.println(" Some Codes5...");
		} catch(ArithmeticException e) {
			/* 예외 처리*/
			// 절대 비워 두지 않는 철학을 가져야 함
			
			e.printStackTrace();
			
			// 로깅
			System.out.println("error: "+e);
			
			//사과
			System.out.println("죄송합니다 ");
			
			//정상 종료
			// System.exit(0);
			
			
		} finally {
			System.out.println("자원 정리: ");
			
		}
		System.out.println(" Some Codes6...");
		System.out.println(" Some Codes7...");
		
		
		

	}

}

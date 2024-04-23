package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] c1=new char[str.length()];
		for(int i=str.length()-1;i>=0;i--) {
			c1[str.length()-1-i]=str.charAt(i);
		}
		char[] chars = str.toCharArray();
		for(int i=0;i<str.length();i++) {
			chars[i]=c1[i];
		}
		
		return chars;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}
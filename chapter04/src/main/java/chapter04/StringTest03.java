package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="Hello " + "World" + " java" + 17;
		String s2= new StringBuffer("Hello ").append("World").append(" java").append(17).toString();
		String s3= new StringBuilder("Hello ").append("World").append(" java").append(17).toString();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		// 시간이 오래걸림
//		String s4="";
//		for(int i=0;i<10e6;i++) {
//			s4+=i;
//		}
		
		
		// 빠름
//		StringBuffer sb=new StringBuffer("");
//		for(int i=0;i<10e6;i++) {
//			sb.append("h");
//		}
		
		
		// String method들
		String s5="aBCdEfGabcABC";
		System.out.println(s5.length());
		System.out.println(s5.charAt(2));
		System.out.println(s5.indexOf("abc"));
		System.out.println(s5.indexOf("abc",8));
		System.out.println(s5.substring(3));
		System.out.println(s5.substring(3,6));
		
		String s6="         abc        de     ";
		String s7="efg,hij,klm,nop";
		
		System.out.println(s6.concat(s7));
		
		System.out.println(s6.trim());
		System.out.println(s6.replaceAll(" ", ""));
		
		System.out.println(s7.split(",")[0]);
		
		
	}

}

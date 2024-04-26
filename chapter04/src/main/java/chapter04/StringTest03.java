package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="Hello " + "World" + " java" + 17;
		String s2= new StringBuffer("Hello ").append("World").append(" java").append(17).toString();
		System.out.println(s1);
		System.out.println(s2);

	}

}

package chapter04;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test a=new Test();
		a.setX(10);
		System.out.println(a.getX());
		Test b=a;
		System.out.println(b.getX());
		a.setX(20);
		System.out.println(a.getX());
		System.out.println(b.getX());
	}

}

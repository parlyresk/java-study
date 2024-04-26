package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point=new Point();
		
		Class klass=point.getClass();
		System.out.println(klass);
		System.out.println(point.hashCode()); // address 기반의 해싱 값
											  // address가 아님 , refrence가 아님
		
		System.out.println(point.toString()); // getClass().toString() + "@" + hashCode()
		System.out.println(point);
	}

}

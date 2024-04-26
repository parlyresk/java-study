package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		try {
			new MyClass().danger();
		} catch (IOException e) {
			
			// System.out.println("error: " + e);
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println("error: "+ e);
		}

	}

}

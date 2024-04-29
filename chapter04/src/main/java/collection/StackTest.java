package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s=new Stack<>();
		
		s.push("둘리");
		s.push("마이클");
		s.push("고길동");
		
		while(!s.isEmpty()) {
			String str=s.pop();
			System.out.println(str);
		}
		
		s.push("둘리");
		s.push("마이클");
		s.push("고길동");
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());

	}

}

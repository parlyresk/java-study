package prob05;

public class MyBase extends Base {
	
	@Override
	public void service(String state) {
		if(state=="낮") {
			System.out.println("낮에는 열심히 일하자!");
		}
		else if(state=="밤"){
			super.service(state);
		}
		else if(state=="오후") {
			System.out.println("오후도 낮과 마찬가지로 일해야 합니다");
		}
	}

}

package mypackage;

public class Goods2 {
	public String name; // 모둔 접근 가능
	protected int price; // 같은 패키지, 자식 접근 가능
	int countStock; // 같은 패키지(default)
	private int countSold; // 클래스 내부에서만 접근 가능함
	
	public void m() {
		countSold=50;
	}
	
}

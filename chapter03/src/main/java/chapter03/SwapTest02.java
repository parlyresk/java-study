package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		int j=20;
		
		System.out.println(i+", "+j);
		swap(i,j);
		
		System.out.println(i+", "+j);

	}

	private static void swap(int m, int n) {
		int t=n;
		n=m;
		m=t;
		
	}

}

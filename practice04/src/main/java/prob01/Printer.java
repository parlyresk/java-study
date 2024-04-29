package prob01;

public class Printer {

//	public void println(int i) {
//		System.out.println(i);
//		
//	}
//	public void println(boolean i) {
//		System.out.println(i);
//		
//	}
//	public void println(double i) {
//		
//		System.out.println(i);
//	}
//	public void println(String i) {
//		
//		System.out.println(i);
//	}
	public <T> void println(T a) {
		System.out.println(a);
		
	}
	
	public int sum(Integer... nums) {
		int s=0;
		for(Integer i : nums) {
			s+=i;
		}
		
		return s;
	}

}

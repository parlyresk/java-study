package thread;

public class DigitThread extends Thread {

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.print(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

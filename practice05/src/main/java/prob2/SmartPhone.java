package prob2;

public class SmartPhone extends Phone {

	
	@Override
	public void execute( String function ) {
		if(function.equals("음악")) {
			playMusic();
			return;
		}
		else if(function.equals("앱")) {
			playApp();
			return;
		}
		super.execute(function);
	}

	private void playMusic() {
		// TODO Auto-generated method stub
		System.out.println("음악 재생합니다");
		
	}

	private void playApp() {
		// TODO Auto-generated method stub
		System.out.println("애플리케이션을 구동합니다");
		
	}
}

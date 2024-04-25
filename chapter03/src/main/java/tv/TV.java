package tv;

public class TV {
	private int volume; //0~100
	private int channel; //1~255
	private boolean power;
	
	public TV(int volume, int channel, boolean power) {
		// TODO Auto-generated constructor stub
		this.volume=volume;
		this.channel=channel;
		this.power=power;
	}

	public void status() {
		System.out.println("volume : " + volume + "  channel : " +channel + "  power :" + (power ? "on" : "off"));
	}

	public void power(boolean b) {
		// TODO Auto-generated method stub
		power=b;
		
	}

	public void volume(boolean b) {
		if(b) {
			// volume up
			volume=(volume+1)%101;
		}
		else {
			// volume down
			volume=(volume+100)%101;
		}
		
	}
	public void volume(int i) {
		// TODO Auto-generated method stub
		if(0<=i && i<=100) {
			volume=i;
		}
		else {
			volume=0;
		}
		
		
	}

	public void channel(boolean b) {
		// TODO Auto-generated method stub
		if(b) {
			channel=(channel%255)+1;
		}
		else {
			channel=(channel-1+254)%255 +1;
		}
		
	}

	public void channel(int i) {
		// TODO Auto-generated method stub
		
		if(1<=i && i<=255) {
			channel=i;
		}
		else {
			channel=1;
		}
		
	}

	
}

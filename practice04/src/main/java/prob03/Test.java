package prob03;

public class Test {

	public static void main(String[] args) {
		Unit tank=new Tank();
		Unit dropship=new DropShip();
		Unit marine=new Marine();
		
		tank.setX(10);
		tank.setY(5);
		dropship.setX(20);
		dropship.setY(30);
		marine.setX(50);
		marine.setY(70);
		
		tank.move(11, 6);
		tank.stop();
		((Tank)tank).changeMode();
		
		dropship.move(21,31);
		dropship.stop();
		((DropShip)dropship).load();
		((DropShip)dropship).unload();
		
		marine.move(51, 71);
		marine.stop();
		((Marine)marine).stimPack();
		

	}

}

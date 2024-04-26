package prob03;

public class Unit {
	// 현재 위치
	protected int x;
	protected int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	void move(int x, int y) {
		/* 지정된 위치로 이동 */
		this.x=x;
		this.y=y;
		System.out.println("("+x+" , "+y+") 로 이동합니다.");
	}

	void stop() {
		/* 현재 위치에 정지 */
		System.out.println("("+x+" , "+y+") 에서 정지합니다.");
	}

}

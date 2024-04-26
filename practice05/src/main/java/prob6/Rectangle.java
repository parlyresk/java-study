package prob6;

public class Rectangle extends Shape implements Resizable{

	public Rectangle(double i, double j) {
		// TODO Auto-generated constructor stub
		super(i,j);
	}

	@Override
	protected double getArea() {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		
		
		return 2*x+2*y;
	}

	@Override
	public void resize(double d) {
		// TODO Auto-generated method stub
		this.x=x*d;
		this.y=y*d;
	}

}

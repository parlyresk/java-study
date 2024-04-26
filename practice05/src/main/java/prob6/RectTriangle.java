package prob6;
import java.lang.Math;
public class RectTriangle extends Shape {

	public RectTriangle(double i, double j) {
		// TODO Auto-generated constructor stub
		super(i,j);
	}

	@Override
	protected double getArea() {
		// TODO Auto-generated method stub
		
		return x*y/2;
	}

	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		return x+y+Math.pow((Math.pow(x, 2)+Math.pow(y, 2)),0.5);
	}

	

}

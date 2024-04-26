package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rectangle;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
		
		Point point1=new Point(10,20);
//		point1.setX(10);
//		point1.setY(20);
		draw(point1);
//		point.disappear();
		point1.show(false);
		
		ColorPoint point2=new ColorPoint(100,200,"red");
		draw(point2);
		
//		drawTriangle(new Triangle());
//		drawRectangle(new Rectangle());
		
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		draw(new GraphicText("HI"));
		
		Circle c = new Circle();
		
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Object);
		
		// 오류: 연산자 우측 항이 클래스인 경우
		//		레퍼런스하고 있는 class 타입의 hierachy 상의 하위 상위만 instanceof 연산자를 사용할 수 있다
		// System.out.println(c instance of Point);
		Object o = new Circle();
		System.out.println(o instanceof String);
		
		// 연산자 우측항이 인터페이스인 경우
		// Hierachy 상관 없이 instanceof 연산자를 사용할 수 있다
		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);
		
		
		
		
		
		
		
	}
	
	
	private static void draw(Drawable drawable) {
		drawable.draw();
	}
//	private static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
//	private static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	
//	private static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
//	}
	
//	private static void drawShape(Shape shape) {
//		shape.draw();
//	}
//	
//	private static void drawPoint(Point point) {
//		point.show();
//	}

}

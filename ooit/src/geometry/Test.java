package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point firstPoint = new Point(10,20);
		Point secondPoint = new Point (40,40);
		Point thirdPoint = new Point (50,100);
		
		Line firstLine = new Line(secondPoint,thirdPoint);
		
		Circle firstCircle = new Circle(firstPoint, 20);
		Circle secondCircle = new Circle(secondPoint,20);
		
		System.out.println("Krug se prvo nalazi na " + firstCircle.toString());
		
		firstCircle.moveBy((int)secondPoint.distance(thirdPoint.getX(), thirdPoint.getY()), 0);
		
		System.out.println("Zatim se nalazi na " + firstCircle.toString());
		
		Rectangle firstRectangle = new Rectangle(firstPoint,30,20);
		Rectangle secondRectangle = new Rectangle(firstPoint,30,20);
		
		System.out.println(firstRectangle.toString());
		
		System.out.println(firstCircle.equals(secondCircle));
		System.out.println(firstRectangle.equals(secondRectangle));


	}

}

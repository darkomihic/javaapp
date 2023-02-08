package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point firstPoint = new Point(20,80);
		Point secondPoint = new Point (40,40);
		Point thirdPoint = new Point (20,80);
		Point fourthPoint = new Point(80,70);
		
		Rectangle firstRectangle = new Rectangle(firstPoint,50,30);

		System.out.println(firstRectangle.toString());
		System.out.println(thirdPoint.toString()+ " " +fourthPoint.toString());
		
		System.out.println(firstRectangle.contains(fourthPoint));
		System.out.println(firstRectangle.contains(thirdPoint));
		
		
		
		


	}

}


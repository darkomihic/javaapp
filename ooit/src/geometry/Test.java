package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point firstPoint = new Point(10,20);
		Point secondPoint = new Point(20,60);
		
		Line firstLine = new Line(firstPoint, secondPoint);
		
		
		
		System.out.println(firstLine.toString() + " duzina je " + firstLine.length());

	}

}

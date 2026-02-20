
public class testGeometricObject {

	public static void main(String[] args) {
		
		Circle cir1 = new Circle("Green", True, 2.0);
		System.out.println("Area of cir1: " + cir1.getArea());
		
		
		int radious = 5;
		System.out.println("A circle with radious " + radius + " will have area " + Circle.getArea(5));
		
		Rectangle rect1 = new Rectangle("red", true, 2.0, 3.0);
		System.out.println("Perimeter = " + rect1.getPerimeter());
		
		Database db = new Database();
		db.write(cir1);
		GeometricObject ob = db.readObject();
		System.out.println(ob);
		db.write(rect1);
	}

}

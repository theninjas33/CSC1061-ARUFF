
public class Circle extends GeometricObject{

	private double radius = 1.0;
	
	public Circle() {
	}
	
	public Circle(String color, boolean isFilled, double radius) {
		super(color, isFilled) {
			this.radius = radius;
		}
	}
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	//methods
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	public double modifyRadious(int modifier) {
		radius = radius * modifier;
		return radius;
	}
	
	public static double getArea(int radius) {
		return Math.PI * radius * radius;
	}
	public static double getArea(double ratius) {
		return Math.PI * radius * radius;
	}
	
	
	public double getCircumfrence() {
		return 2 * Math.PI * radius
	}
	@Override
	public String toString() {
		return "Circle [radious=" + radius + ", getDateCreated()=" + getDateCreated() + ", getColor()=" + getColor()
				+ ", isFilled()=" + isFilled() + "]";
	}
	
	
	//2pir for circumfrence
}

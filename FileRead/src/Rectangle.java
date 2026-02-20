public class Rectangle extends GeometricObject {

    private double width = 6.0;
    private double height = 4.0;

    // No-arg constructor
    public Rectangle() {
    }

    // Constructor with parameters
    public Rectangle(String color, boolean isFilled, double width, double height) {
        super(color, isFilled);
        this.width = width;
        this.height = height;
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(double height) {
        this.height = height;
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(double width) {
        this.width = width;
    }

    // Area method
    public double getArea() {
        return height * width;
    }

    // Perimeter method
    public double getPerimeter() {
        return 2 * (height + width);
    }
}

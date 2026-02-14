public class Fan {

    // Speed constants
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Static counter for assigning unique IDs
    private static int nextId = 1;

    // Data fields
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    private int id;

    // No-arg constructor
    public Fan() {
        id = nextId++;
    }

    // Accessors (getters)
    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    // Mutators (setters)
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString method
    @Override
    public String toString() {
        if (on) {
            return "Fan ID: " + id +
                   ", Speed: " + speed +
                   ", Color: " + color +
                   ", Radius: " + radius;
        } else {
            return "Fan ID: " + id +
                   ", Color: " + color +
                   ", Radius: " + radius +
                   " — fan is off";
        }
    }
}

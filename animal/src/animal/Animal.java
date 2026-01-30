package animal;

public class Animal {

    private String name;
    private double weight;
    private double height;

    // No-argument constructor (default)
    public Animal() {
        name = "LivingThing";
        weight = 1.0;
        height = 1.0;
    }

    // Parameterized constructor
    public Animal(String name, double weight, double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Method
    public String makeSound() {
        return "Bla bla";
    }
}

package animal;

public class Cat extends Animal {

    private int lengthOfWhiskers;

    // No-arg constructor
    public Cat() {
        super();
        lengthOfWhiskers = 0;
    }

    // Parameterized constructor
    public Cat(String name, double weight, double height, int lengthOfWhiskers) {
        super(name, weight, height);
        this.lengthOfWhiskers = lengthOfWhiskers;
    }

    public int getLengthOfWhiskers() {
        return lengthOfWhiskers;
    }

    public void setLengthOfWhiskers(int lengthOfWhiskers) {
        this.lengthOfWhiskers = lengthOfWhiskers;
    }

    @Override
    public String makeSound() {
        return "Meow";
    }

    @Override
    public String toString() {
        return "Cat [name=" + getName()
                + ", weight=" + getWeight()
                + ", height=" + getHeight()
                + ", whiskerLength=" + lengthOfWhiskers + "]";
    }
}

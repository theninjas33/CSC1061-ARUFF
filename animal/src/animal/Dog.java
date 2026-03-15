package animal;

public class Dog extends Animal {

    private int BarkDB;

    public Dog(int BarkDB) {
        super();
        this.setName("Buster");
        this.BarkDB = BarkDB;
    }

    public Dog(String name, double weight, double height, int wlength) {
        super(name, weight, height);
        BarkDB = wlength;
    }

    @Override
    public String makeSound() {
        return "Bow Wow";
    }
}
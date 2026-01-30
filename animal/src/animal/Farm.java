package animal;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    public static void main(String[] args) {

        // Array of Animals
        Animal[] animals = new Animal[3];

        // ArrayList of Animals
        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Cat("Orange", 2.0, 2.0, 3));

        Dog rufus = new Dog("Rufus", 4.0, 3.0, 5);
        animalList.add(rufus);

        animals[0] = new Cat("Tabby", 2.0, 1.0, 3);

        Horse horse = new Horse();
        animals[1] = horse;
        printAnimal(horse);

        animals[2] = new Dog("Rufus", 4.0, 2.0, 3);

        Cat tango = new Cat("Tango", 3.0, 2.0, 1);
        System.out.println(tango);

        System.out.println(tango.makeSound());

        Horse roscoe = new Horse();
        roscoe.setName("Roscoe");
        System.out.println(roscoe.makeSound());

        // Loop through animals
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].makeSound());
        }

        for (Animal theAnimal : animals) {
            System.out.println(theAnimal.makeSound());
            printAnimal(theAnimal);
            printWithoutToString(theAnimal);
        }
    }

    public static void printAnimal(Animal anim) {
        System.out.println(anim);
    }

    public static void printWithoutToString(Animal anim) {
        System.out.println(
                "Name = " + anim.getName() +
                ", Weight = " + anim.getWeight() +
                ", Height = " + anim.getHeight()
        );

        if (anim instanceof Cat) {
            int lengthOfWhiskers = ((Cat) anim).getLengthOfWhiskers();
            System.out.println("Length of whiskers = " + lengthOfWhiskers);
        }

        if (anim instanceof Dog) {
            int volumeOfBark = ((Dog) anim).getVolumeOfBark();
            System.out.println("Volume of Bark = " + volumeOfBark);
        }
    }
}

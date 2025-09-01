class Creature {
    void makeSound() {
        System.out.println("Creature makes some sound");
    }
}

class Lion extends Creature {
    void makeSound() {
        System.out.println("Lion roars");
    }
}

class Parrot extends Creature {
    void makeSound() {
        System.out.println("Parrot chirps");
    }
}

class Frog extends Creature {
    void makeSound() {
        System.out.println("Frog croaks");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Creature c;

        c = new Lion();
        c.makeSound();

        c = new Parrot();
        c.makeSound();

        c = new Frog();
        c.makeSound();
    }
}


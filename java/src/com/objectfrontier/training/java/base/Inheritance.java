package com.objectfrontier.training.java.base;
public class Inheritance {

    // void execute() {
    public static void main(String[] arg) {

        Dog d = new Dog();
        d.bark("Owner");
        Animal c = new Cat();
        c.eat();
        Snake s = new Snake();
        s.bites();
    }
}

class Animal {

    static int eyes = 2;
    int legs;
    String colour = "white";

    public void sleep() {

        // console.print(Animal sleeping);
        System.out.println("Animal is sleeping");
    }

    public void eat() {

        // console.print(Animal eating);
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {

    String breed;

    public void bark() {

        // console.print(Dog barks);
        System.out.println("Dog barks");
    }

    public void bark(String person) {

        if (person == "Owner") {

            // console.print(Dog barks friendly);
            System.out.println("Dog barks friendly");
        } else if (person == "Stranger") {

            // console.print(Dog barks angrily);
            System.out.println("Dog barks angrily");
        }
    }
}

class Cat extends Animal {

    public void eat() {

        // console.print(Cat eating);
        System.out.println("Cat is eating");
    }
}

class Snake extends Animal {

    String breed = "Kingsnakes";

    public void bites() {

        // console.print(Snake bites);
        System.out.println("Snake bites");
    }
}

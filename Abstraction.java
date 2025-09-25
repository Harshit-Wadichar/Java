abstract class Animal {
    //The abstract keyword is used to define a class or method that doesn’t have a complete
    // implementation—it’s meant to be extended or completed by other classes.
    abstract void walk();
    void eats(){
        System.out.println("animal eats");
    }
    //constructor
    Animal(){
        System.out.println("You have created an Animal");
    }
}

class Horse extends Animal {
    void walk() {
        System.out.println("Walks on 4 legs");
    }
    Horse(){
        System.out.println("You have created a horse");
    }
}

class Chicken extends Animal {
    void walk() {
        System.out.println("Walks on 2 legs");
    }
}

public class Abstraction {
    public static void main(String args[]){
       Horse horse = new Horse();
       horse.walk();
       horse.eats();
       //can not create objects of abstract class
       //Animal animal = new Animal();
       //animal.walk();
        // error: Animal is abstract; cannot be instantiated


    }
}

/*
📌 Characteristics of abstract:
- An abstract class can’t be directly instantiated (you can’t create objects from it).
- It can contain abstract methods (no body) and regular methods (with body).
- An abstract method must be implemented by subclasses.
- Helps enforce a common structure across related classes.

🎯 Why Use It?
- To define a blueprint for other classes.
- To achieve partial abstraction—you hide some implementation but allow flexibility.
- Useful when you want to force subclasses to implement specific behavior.

*/

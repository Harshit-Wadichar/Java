interface Animals{
    public void walk();
     //interface can not have constructor
    //can not have non abstract function

}

interface Harbivore{

    
}

class Dog implements Animals, Harbivore{
    public void walk(){
        System.out.println("walks on four legs");
    }
}

class Students {
    String name;

    //static keyword makes a certain variable to have same value for all of the instances or objects
    static String school;

    public static void changeSchool() {
        school = "newschool";
    }
}


public class Interface {
     public static void main(String args[]){
         Dog dog = new Dog();
         dog.walk();

         Students.school = "ABC";
         Students student1 = new Students();
         student1.name = "tony";
         System.out.println(student1.school);

     }
}

/*
An interface is like a contract that defines what methods a class must implement—but it doesn’t provide the actual code for those methods.

📌 Characteristics of an Interface:
- Only contains method declarations (no method bodies, unless it's a default or static method).
- All methods are implicitly public and abstract.
- Variables in an interface are public, static, and final by default.
- A class uses implements to follow the interface.
- A class can implement multiple interfaces (Java doesn’t support multiple inheritance with classes, but interfaces solve that).

🎯 Why Use Interfaces?
- To achieve abstraction: you define what should be done, not how.
- To support multiple inheritance in a clean way.
- To allow flexible architecture: different classes can implement the same interface differently.

*/
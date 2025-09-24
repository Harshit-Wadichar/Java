import bank.Account;

class Pen {
    // this is a class

    //this are properties of the objects of the class
    String color;
    String type; //ballpoint; gel;

    //this are methods or functions which a class can perform or a class can do
    public void write() {
        System.out.println("writing something");
    }

    public void printColor(){
        System.out.println("Color of this pen :"+ this.color);
    }
}

class Student {
    String name;
    int age;

    //when more than two methods have the same method or function name then this is called as polymorphism
    public void printInfo(int age){
        System.out.println(this.age);
    }

    public void printInfo(String name){
        System.out.println(this.name);
    }

    public void printInfo(int age, String name){
        System.out.println(this.name);
        System.out.println(this.age);
    }


    //this is a constructor
    //a constructor automatically get called if any object is created
    //simple constructor
    Student(){

    }

    //parameterized constructor
    Student(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("this is the constructor");
    }

    //copy constructor
    Student(Student s2){
        this.name = s2.name;
        this.age = s2.age;
    }
}

class shape{
    String color;
}

class rectangle extends shape{

}

public class OOPS {
    public static void main(String args[]){
        Account account1 = new Account();
        account1.name = "Ankit";

        //this is how the object of the class is made
        Pen pen1 = new Pen(); //here Pen() is the constructor and Pen is the type of the object
        pen1.color = "blue";
        pen1.type = "gel";

        pen1.write(); //this is how the methods of the class is called
        pen1.printColor();

        Pen pen2 = new Pen();
        pen2.color = "black";
        pen2.type = "ballpoint";

        pen2.printColor();

        Student s1 = new Student("harshit", 20);

        s1.printInfo(s1.age);

        Student s2 = new Student("ankit", 26);
        s2.printInfo(s2.name);

        Student s3 = new Student(s1);
        s3.printInfo(s3.age, s3.name);

        rectangle r1 = new rectangle();
        r1.color = "blue";
    }
}

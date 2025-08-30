import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Exercise01 {

    public static void average(int a, int b, int c){
        //Enter 3 numbers from the user & make a function to print their average.
        System.out.println((a+b+c)/3);
    }

    public static void sumOfOddNo(int n){
        // Write a function to print the sum of all odd numbers from 1 to n.
        int sum = 0;
        for(int i = 1; i <=n; i++){
            if(i%2!=0){
                sum = sum + i;
            }
        }
        System.out.println("sum of odd no. : " + sum);
    }

    public static void greaterOutOfTwo(int a, int b){
        // Write a function which takes in 2 numbers and returns the greater of those two.
        if (a>b){
            System.out.println(a+" is greater then " + b);
        }
        else {
            System.out.println(b+" is greater then " + a);
        }
    }

    public static void circumferenceOfCircle(int r){
        /* Write a function that takes in the radius as input and returns the
           circumference of a circle.  */
        double circumference = ((2 * 3.14) * r);
        System.out.println("circumference of circle is "+ circumference);
    }

    public static void eligibleForVoting(int age){
        /* Write a function that takes in age as input and returns if that person is eligible
           to vote or not. A person of age > 18 is eligible to vote.  */

        if(age>18){
            System.out.println("the person with "+ age + " is eligible to vote");
        }
        else{
            System.out.println("the person with "+ age + " is not eligible to vote");
        }
    }

    public static void infiniteDoWhileLoop(){
        /* Write an infinite loop using do while condition.  */
        for(int i =1 ; i >= 2/*0*/ ; i++){
            System.out.print(" H ");
        }
    }

    public static void enteredNoInfo(){
        /* Write a program to enter the numbers till the user wants and at the end it
          should display the count of positive, negative and zeros entered.  */
        Scanner sc = new Scanner(System.in);
        int positiveCount = 0, negativeCount = 0, zeroCount = 0;
        char choice;

        do {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            if (num > 0) positiveCount++;
            else if (num < 0) negativeCount++;
            else zeroCount++;

            System.out.print("Do you want to enter another number? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');

        System.out.println("\nSummary:");
        System.out.println("Positive numbers: " + positiveCount);
        System.out.println("Negative numbers: " + negativeCount);
        System.out.println("Zeros: " + zeroCount);

    }

        // Function to calculate x raised to the power n
        public static void power(double x, int n) {
        /*  Two numbers are entered by the user, x and n. Write a function to find
             the value of one number raised to the power of another i.e. . */
            double result = 1;
            for (int i = 0; i < Math.abs(n); i++) {//math.abs() function conversts negative values into positive
                result *= x;
            }
             if(n == 0){
                 System.out.println("the value of "+x+" raise to power " + n +" is "+ 1);
             }
             else {
                 System.out.println("the value of " + x + " raise to power " + n + " is " + result);
             }
        }

    public static void gcd(int a, int b) {
        /*  Write a function that calculates the Greatest Common Divisor of 2 numbers.  */
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("gcd of entered two no. is "+Math.abs(a)); // Ensures GCD is always positive
    }

    public static void fibonacci(int n){
        /* . Write a program to print Fibonacci series of n terms where n is input
         by user :
         0 1 1 2 3 5 8 13 21 .....
        In the Fibonacci series, a number is the sum of the previous 2 numbers that
        came before it.  */
        int a = 0;
        int b = 1;
        for(int i = 0; i<=n; i++){
            System.out.println(a+ " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
    }


    public static void main( String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("enter 3 no. :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        average(a,b,c);

        System.out.println("Enter no n:");
        int n = sc.nextInt();
        sumOfOddNo(n);

        System.out.println("Enter two no. to find out which is greater");
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        greaterOutOfTwo(a1,a2);

        System.out.println("Enter radius of circle to find its circumference");
        int r = sc.nextInt();
        circumferenceOfCircle(r);

        System.out.println("Enter a persons age to know if he/she is eligible to vote or not");
        int age = sc.nextInt();
        eligibleForVoting(age);

        infiniteDoWhileLoop();
        enteredNoInfo();

            System.out.println("to calculate the value of x raised to power n enter the values of x and n:");
            System.out.println("enter x: ");
            int x = sc.nextInt();
            System.out.println("enter n: ");
            int n2 = sc.nextInt();

            power(x, n2);

        System.out.println("to calculate the greatest common divisor of 2 no. enter the value of num1 and num2:");
        System.out.println("enter num1: ");
        int num1 = sc.nextInt();
        System.out.println("enter num2: ");
        int num2 = sc.nextInt();

        gcd(num1, num2);

        System.out.println("enter a no. f to find fibonacci serie of length of f :");
        System.out.println("Enter f : ");
        int f = sc.nextInt();
        fibonacci(f);
    }

}

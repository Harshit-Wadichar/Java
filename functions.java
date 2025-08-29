import java.util.Scanner;

public class Functions {

    public static void printMyName(String name){
        System.out.println(name);
        return;
    }

    public static int calculateSum(int a, int b){
        int sum = a + b;
        return sum;
    }

    public static int calculateProduct(int a, int b){
        int product = a * b;
        return product;
    }

    public static int factorial(int no){
        int factorial = no;
        if(no==0) {
            System.out.println("the factorial of 0 is always 1");
        }
        else {
            for (int i = 1; i < no; i++) {
                factorial = factorial * i;
            }
        }
        System.out.println("the factorial of "+no+" is "+factorial);
        return factorial;
    }

    public static void main( String[] args){

        System.out.print("Enter your name : ");
       Scanner sc = new Scanner(System.in);

        String name = sc.next();

        int a = sc.nextInt();
        int b = sc.nextInt();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int factorial = sc.nextInt();

       printMyName(name);
        System.out.println(calculateSum(a,b));
        System.out.println(calculateProduct(n,m));
        factorial(factorial);



    }
}

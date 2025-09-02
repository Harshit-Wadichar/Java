public class Recursion1 {

    // Prints numbers from n to 1
    public static void printNum1(int n) {
        if (n == 0) return;
        System.out.println(n);
        printNum1(n - 1);
    }

    // Prints numbers from h to 5
    public static void printNum2(int h) {
        if (h == 6) return;
        System.out.println(h);
        printNum2(h + 1);
    }

    // Prints sum of numbers from i to n
    public static void printSum(int i, int n, int sum) {
        if (i == n) {
            sum += i;
            System.out.println("Sum: " + sum);
            return;
        }
        sum += i;
        printSum(i + 1, n, sum);
    }

    // Calculates factorial of n
    public static int calcFactorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * calcFactorial(n - 1);
    }

    // Prints Fibonacci series up to n terms
    public static void printFib(int a, int b, int n) {
        if (n == 0) return;
        int c = a + b;
        System.out.print(c + " ");
        printFib(b, c, n - 1);
    }

    // Calculates x^n using linear recursion
    public static int calcPower(int x, int n) {
        if (n == 0) return 1;
        return x * calcPower(x, n - 1);
    }

    // Calculates x^n using divide-and-conquer (log(n) stack height)
    public static int calcPower2(int x, int n) {
        if (n == 0) return 1;
        int halfPower = calcPower2(x, n / 2);
        return (n % 2 == 0) ? halfPower * halfPower : halfPower * halfPower * x;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Descending from " + n + ":");
        printNum1(n);

        System.out.println("\nAscending from 1 to 5:");
        printNum2(1);

        System.out.println("\nSum from 1 to 5:");
        printSum(1, 5, 0);

        System.out.println("\nFactorial of " + n + ": " + calcFactorial(n));

        System.out.println("\nFibonacci series up to 7 terms:");
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        printFib(a, b, 5); // Already printed first two

        int x = 2;
        System.out.println("\n\n" + x + "^" + n + " using linear recursion: " + calcPower(x, n));
        System.out.println(x + "^" + n + " using optimized recursion: " + calcPower2(x, n));
    }
}
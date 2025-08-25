import java.util.Arrays;
import java.util.Scanner;

/**
 * A friendly, well-commented demo of basic Java concepts:
 * - printing and methods
 * - primitive vs reference types
 * - strings and immutability
 * - arrays (1D & 2D) and Arrays.sort
 * - casting and constants (final)
 * - operators (arithmetic, modulo, unary)
 * - Math utilities and random
 * - Scanner input (tips included)
 * - conditionals, switch
 * - loops (for, while, do-while)
 * - try-catch for exception handling
 *
 * The code is intentionally verbose with comments so it's great for learning.
 */
public class Main {

    public static void main(String[] args) {
        // Use a single Scanner for all user input. Close it at the end.
        Scanner sc = new Scanner(System.in);

        greet();

        // Demonstrations
        demonstratePrimitivesAndReferences();
        demonstrateStrings();
        demonstrateArrays();
        demonstrateCastingAndConstants();
        demonstrateOperatorsAndMath();
        demonstrateScannerInput(sc);       // shows how to take input safely
        demonstrateConditionals(sc);       // uses the Scanner for input-driven decisions
        demonstrateSwitch();
        demonstrateLoops();
        demonstrateExceptionHandling();

        // Methods example
        printName("Harshit");
        helloWorld();

        // Close the scanner to free system resources
        sc.close();
    }

    // -------------------------
    // Basic printing and methods
    // -------------------------
    public static void greet() {
        // println ends the line, print doesn't — useful distinction when formatting output.
        System.out.println("Hello and welcome!");
        System.out.print("This is printed without a newline -> ");
        System.out.println("now this prints on the same line after the previous print.");
        System.out.println();
    }

    public static void printName(String name) {
        System.out.println("Name: " + name);
    }

    public static void helloWorld() {
        System.out.println("hello world");
    }

    // -----------------------------------
    // Primitive vs Reference types demo
    // -----------------------------------
    public static void demonstratePrimitivesAndReferences() {
        // Primitive types (stored by value)
        byte smallNumber = 12;              // 1 byte
        int phone = 1_234_567_890;          // 4 bytes
        long bigNumber = 12_345_678_900L;   // 8 bytes (note the 'L' suffix)
        float piFloat = 3.14F;              // 4 bytes ('F' suffix)
        char symbol = '@';                  // 2 bytes (UTF-16)
        boolean isAdult = false;            // true/false

        // Reference type (String is an object)
        String personName = "Apu";          // stored as a reference (heap)

        // Quick prints
        System.out.println("Primitive example - smallNumber: " + smallNumber);
        System.out.println("Reference example - personName length: " + personName.length());

        // Note: primitives cannot be null, references can be null.
        System.out.println();
    }

    // ---------------------
    // Strings (immutable)
    // ---------------------
    public static void demonstrateStrings() {
        String name1 = "Aman";
        String name2 = "Akku";
        // concatenation
        String combined = name1 + " " + name2;   // Strings are immutable; + creates a new String
        System.out.println("Concatenated: " + combined);

        String bro = "harshit";
        System.out.println("charAt(0): " + bro.charAt(0)); // first character
        System.out.println("length(): " + bro.length());

        // replace example - original string is unchanged
        String original = "Harshit";
        String replaced = original.replace('a', 'b'); // returns a new String
        System.out.println("Original: " + original + " | Replaced: " + replaced);

        // substring(start, end) - end is exclusive
        String full = "hashit";
        System.out.println("substring(3,5): " + full.substring(3, 5)); // indices 3 and 4

        System.out.println();
    }

    // ---------------------------
    // Arrays: 1D and 2D examples
    // ---------------------------
    public static void demonstrateArrays() {
        // 1D array with explicit initialization
        int[] marks = new int[3]; // default values are 0
        marks[0] = 97;
        marks[1] = 98;
        marks[2] = 91;

        System.out.println("marks[0] before sort: " + marks[0]);
        System.out.println("marks.length: " + marks.length);

        // sorting modifies the array in-place
        Arrays.sort(marks);
        System.out.println("marks[0] after sort (smallest): " + marks[0]);

        // array literal syntax
        int[] array = {1, 2, 3, 4, 5};

        // 2D array (matrix-like)
        int[][] finalMarks = {{98, 92, 95}, {97, 99, 90}};
        System.out.println("finalMarks[0][0]: " + finalMarks[0][0]); // 98
        System.out.println("finalMarks[1][0]: " + finalMarks[1][0]); // 97

        System.out.println();
    }

    // -----------------------------------
    // Casting (explicit) and constants
    // -----------------------------------
    public static void demonstrateCastingAndConstants() {
        // Implicit widening
        double price = 100.00;
        double finalPrice = price + 18; // 118.0
        System.out.println("finalPrice (double): " + finalPrice);

        // Narrowing requires explicit cast
        int p = 100;
        int fP = p + (int) 18.18; // fractional part lost
        System.out.println("fP (after cast): " + fP);

        // final makes a constant (by convention use uppercase names)
        final float PI = 3.14F;
        System.out.println("Constant PI: " + PI);

        System.out.println();
    }

    // --------------------------------------
    // Operators and Math utility examples
    // --------------------------------------
    public static void demonstrateOperatorsAndMath() {
        double a = 1;
        double b = 2;
        double div = a / b;      // division
        double remainder = a % b; // modulo
        System.out.println("1 / 2 = " + div);
        System.out.println("1 % 2 = " + remainder);

        // Unary operator examples (brief)
        int x = 5;
        System.out.println("+x -> " + +x);
        System.out.println("-x -> " + -x);
        System.out.println("++x (pre-increment) -> " + ++x); // x becomes 6

        // Math utilities
        System.out.println("Math.min(5,6) -> " + Math.min(5, 6));
        System.out.println("Math.max(5,6) -> " + Math.max(5, 6));
        System.out.println("Random int [0..99] -> " + (int) (Math.random() * 100));

        System.out.println();
    }

    // -----------------------------------
    // Demonstration of Scanner inputs
    // -----------------------------------
    public static void demonstrateScannerInput(Scanner sc) {
        System.out.print("Enter your age (integer) and press Enter: ");
        // Tip: if input is not an integer, nextInt() will throw InputMismatchException.
        // You can catch and handle that in production code.
        if (sc.hasNextInt()) {
            int ageInput = sc.nextInt();
            System.out.println("You entered: " + ageInput);
        } else {
            System.out.println("No valid integer entered. Skipping.");
            sc.nextLine(); // consume invalid token
        }

        // Scanner methods quick summary (in comments):
        /*
         * nextInt()     - reads an int
         * nextDouble()  - reads a double
         * nextFloat()   - reads a float
         * nextLong()    - reads a long
         * next()        - reads a single token (word)
         * nextLine()    - reads the rest of the current line (including spaces)
         *
         * Quick tip: If you call nextLine() after nextInt(), consume the newline first:
         * sc.nextLine(); // consume leftover newline
         */

        System.out.println();
    }

    // -----------------------------------
    // Conditionals and logical operators
    // -----------------------------------
    public static void demonstrateConditionals(Scanner sc) {
        System.out.print("Enter cash amount (integer) to run a small conditional demo: ");
        int cash = 0;
        if (sc.hasNextInt()) {
            cash = sc.nextInt();
        } else {
            System.out.println("Invalid input. Using default cash = 0.");
            sc.nextLine();
        }

        if (cash < 10) {
            System.out.println("cannot buy anything\nget more cash");
        } else if (cash >= 10 && cash < 50) {
            System.out.println("can get 1 thing");
        } else {
            System.out.println("can get both");
        }

        // Logical operators example
        int a2 = 60;
        int b2 = 40;
        if (a2 < 50 && b2 < 50) {
            System.out.println("both less than 50");
        }
        if (a2 < 50 || b2 < 50) {
            System.out.println("at least one less than 50");
        }

        // negation example
        boolean isAdult = false;
        if (!isAdult) {
            System.out.println("not adult (negation used)");
        } else {
            System.out.println("is adult");
        }

        System.out.println();
    }

    // -----------------------------------
    // Switch statement example
    // -----------------------------------
    public static void demonstrateSwitch() {
        int day = 1; // 1 - Monday, 2 - Tuesday ...
        switch (day) {
            case 1:
                System.out.println("monday");
                break;
            case 2:
                System.out.println("tuesday");
                break;
            default:
                System.out.println("wed - sun");
        }

        System.out.println();
    }

    // ----------------------
    // Loops examples
    // ----------------------
    public static void demonstrateLoops() {
        // for loop ascending (example limited to 1..10 to avoid huge output)
        System.out.println("for loop ascending 1..10:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // for loop descending
        System.out.println("for loop descending 10..1:");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // while loop example (won't run because condition false)
        int j = 0;
        System.out.println("\nwhile loop: (won't print because condition is false)");
        while (j >= 1) {
            System.out.println(j);
            j--;
        }

        // do-while example (runs at least once)
        int k = 3;
        System.out.println("\ndo-while loop (prints 3,2,1):");
        do {
            System.out.print(k + " ");
            k--;
        } while (k >= 1);
        System.out.println();

        // break and continue example
        System.out.println("\nbreak & continue example:");
        int count = 0;
        while (true) {
            if (count == 3) {
                count = count + 1; // modify before continue to avoid infinite loop
                count++;           // increment twice to demonstrate changes (this is just an example)
                // continue skips the rest of this iteration
                continue;
            }
            System.out.println("count = " + count);
            count = count + 1;
            if (count > 5) {
                // exit the loop
                break;
            }
        }

        System.out.println();
    }

    // -----------------------------------------
    // Exception handling: try-catch example
    // -----------------------------------------
    public static void demonstrateExceptionHandling() {
        int[] marks = {97, 98, 95}; // length 3 -> valid indices 0..2

        try {
            // Intentionally access invalid index to show exception handling
            System.out.println("Attempting to access marks[5] (out of bounds)...");
            System.out.println(marks[5]); // will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            // Provide a helpful error message to the user
            System.out.println("Invalid index: " + e.getMessage());
            // In production code we might log the exception or recover gracefully
        }

        System.out.println("Continuing program after exception handling.");
        System.out.println();
    }
}

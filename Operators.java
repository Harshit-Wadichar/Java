public class Operators {
    public static void main(String[] args) {

        // -------------------- Unary Operators --------------------
        int x = 5;
        System.out.println("Unary Operators Example:");
        System.out.println("Initial value of x: " + x);

        System.out.println("Unary plus (+x): " + (+x));
        System.out.println("Unary minus (-x): " + (-x));
        System.out.println("Post-increment (x++): " + (x++));
        System.out.println("Value of x after post-increment: " + x);
        System.out.println("Pre-increment (++x): " + (++x));
        System.out.println("Pre-decrement (--x): " + (--x));
        System.out.println("Post-decrement (x--): " + (x--));
        System.out.println("Value of x after post-decrement: " + x);

        boolean flag = true;
        System.out.println("Logical NOT (!flag): " + (!flag));

        // -------------------- Binary Operators --------------------
        int a1 = 10, b1 = 4;
        System.out.println("\nBinary Operators Example:");
        System.out.println("a1 = " + a1 + ", b1 = " + b1);

        System.out.println("Addition (a1 + b1): " + (a1 + b1));
        System.out.println("Subtraction (a1 - b1): " + (a1 - b1));
        System.out.println("Multiplication (a1 * b1): " + (a1 * b1));
        System.out.println("Division (a1 / b1): " + (a1 / b1));
        System.out.println("Modulus (a1 % b1): " + (a1 % b1));

        System.out.println("a1 > b1: " + (a1 > b1));
        System.out.println("a1 < b1: " + (a1 < b1));
        System.out.println("a1 == b1: " + (a1 == b1));
        System.out.println("a1 != b1: " + (a1 != b1));

        boolean condition1 = (a1 > b1);
        boolean condition2 = (a1 < 20);
        System.out.println("condition1 && condition2: " + (condition1 && condition2));
        System.out.println("condition1 || condition2: " + (condition1 || condition2));

        // -------------------- Binary to Decimal Conversion --------------------
        String binaryStr = "1011";
        int decimalValue = Integer.parseInt(binaryStr, 2);
        System.out.println("\nBinary to Decimal:");
        System.out.println("Binary " + binaryStr + " = Decimal " + decimalValue);

        // -------------------- Decimal to Binary Conversion --------------------
        int decimalNum = 11;
        String binaryValue = Integer.toBinaryString(decimalNum);
        System.out.println("\nDecimal to Binary:");
        System.out.println("Decimal " + decimalNum + " = Binary " + binaryValue);

        // -------------------- Bitwise Operators --------------------
        int a2 = 5, b2 = 3;
        System.out.println("\nBitwise Operators Example:");
        System.out.println("a2 = " + a2 + " (binary " + Integer.toBinaryString(a2) + ")");
        System.out.println("b2 = " + b2 + " (binary " + Integer.toBinaryString(b2) + ")");

        System.out.println("a2 & b2 = " + (a2 & b2) + " (binary " + Integer.toBinaryString(a2 & b2) + ")");
        System.out.println("a2 | b2 = " + (a2 | b2) + " (binary " + Integer.toBinaryString(a2 | b2) + ")");
        System.out.println("a2 ^ b2 = " + (a2 ^ b2) + " (binary " + Integer.toBinaryString(a2 ^ b2) + ")");
        System.out.println("~a2 = " + (~a2) + " (binary " + Integer.toBinaryString(~a2) + ")");
        System.out.println("a2 << 1 = " + (a2 << 1) + " (binary " + Integer.toBinaryString(a2 << 1) + ")");
        System.out.println("a2 >> 1 = " + (a2 >> 1) + " (binary " + Integer.toBinaryString(a2 >> 1) + ")");
        System.out.println("a2 >>> 1 = " + (a2 >>> 1) + " (binary " + Integer.toBinaryString(a2 >>> 1) + ")");

        // -------------------- Assignment Operators --------------------
        int a3 = 10, b3 = 4;
        System.out.println("\nAssignment Operators Example:");
        System.out.println("Initial values: a3 = " + a3 + ", b3 = " + b3);

        a3 = 20;
        System.out.println("After 'a3 = 20': a3 = " + a3);

        a3 += 5;
        System.out.println("After 'a3 += 5': a3 = " + a3);

        a3 -= 10;
        System.out.println("After 'a3 -= 10': a3 = " + a3);

        a3 *= 2;
        System.out.println("After 'a3 *= 2': a3 = " + a3);

        a3 /= 6;
        System.out.println("After 'a3 /= 6': a3 = " + a3);

        a3 %= 3;
        System.out.println("After 'a3 %= 3': a3 = " + a3);

        // -------------------- Bitwise Assignment Operators --------------------
        a3 = 5; b3 = 3;
        System.out.println("\nBitwise Assignment Operators Example:");
        System.out.println("Reset values: a3 = " + a3 + " (binary " + Integer.toBinaryString(a3) +
                "), b3 = " + b3 + " (binary " + Integer.toBinaryString(b3) + ")");

        a3 &= b3;
        System.out.println("After 'a3 &= b3': a3 = " + a3 + " (binary " + Integer.toBinaryString(a3) + ")");

        a3 = 5;
        a3 |= b3;
        System.out.println("After 'a3 |= b3': a3 = " + a3 + " (binary " + Integer.toBinaryString(a3) + ")");

        a3 = 5;
        a3 ^= b3;
        System.out.println("After 'a3 ^= b3': a3 = " + a3 + " (binary " + Integer.toBinaryString(a3) + ")");

        a3 = 5;
        a3 <<= 1;
        System.out.println("After 'a3 <<= 1': a3 = " + a3 + " (binary " + Integer.toBinaryString(a3) + ")");

        a3 = 5;
        a3 >>= 1;
        System.out.println("After 'a3 >>= 1': a3 = " + a3 + " (binary " + Integer.toBinaryString(a3) + ")");

        a3 = -5;
        a3 >>>= 1;
        System.out.println("After 'a3 >>>= 1': a3 = " + a3 + " (binary " + Integer.toBinaryString(a3) + ")");
    }
}

public class BitManipulation {
    public static void main(String args[]) {

        //Q) Get the 3rd bit(pos = 2) of a number n.(n = 0101)
        //ans => step 1: Bit mask: 1 << pos
        // step 2: AND
        int n = 5; // Binary: 0101 — the number we want to inspect
        int pos = 2; // We want to check the bit at position 3 (counting from 0, right to left)

        int bitMask = 1 << pos; // Shift 1 left by 'pos' bits → creates a mask like 1000 (binary)

        // Perform bitwise AND between n and bitMask
        // If result is 0, the bit at 'pos' is not set (i.e., it's 0)
        if ((bitMask & n) == 0) {
            System.out.println("bit was zero");
        } else {
            // If result is non-zero, the bit at 'pos' is set (i.e., it's 1)
            System.out.println("bit was one");
        }

        //set the second bit(positon = 1) of a number n. (n=0101)
        //ans => step 1: Bit mask: 1 << pos
        // step 2: OR
        int n1 = 5; // Binary: 0101 — the number we want to inspect
        int pos1 = 1; // We want to check the bit at position 3 (counting from 0, right to left)

        int bitMask1 = 1 << pos1; // Shift 1 left by 'pos' bits → creates a mask like 1000 (binary)

        int newNumber = bitMask1 | n1;
        System.out.println(newNumber);

        //Q) Clear the 3rd bit(pos = 2) of a number n.(n = 0101)
        //ans => step 1: Bit mask: 1 << pos
        // step 2: n AND with NOT(bitmask)
        int n2 = 5; // Binary: 0101 — the number we want to inspect
        int pos2 = 2; // We want to check the bit at position 3 (counting from 0, right to left)

        int bitMask2 = (1 << pos2); // Shift 1 left by 'pos' bits → creates a mask like 1000 (binary)

        int newNumber2 = n2 & ~bitMask2;
        System.out.println(newNumber2);

        //Update the second bit(pos = 1) of a number n to 1; (n = 0101)
        //ans=>
        //method 1: to convert a no to 1(Set operation)
        //ans => step 1: Bit mask: 1 << pos
        // step 2: OR
        int n3 = 5; // Binary: 0101 — the number we want to inspect
        int pos3 = 1; // We want to check the bit at position 3 (counting from 0, right to left)

        int bitMask3 = 1 << pos3; // Shift 1 left by 'pos' bits → creates a mask like 1000 (binary)

        int newNumber3 = bitMask3 | n3;
        System.out.println(newNumber3);
        //Update the third bit(pos = 2) of a number n to 0; (n = 0101)
        //method 2: to convert a no to 0(Clear operation)
        //ans => step 1: Bit mask: 1 << pos
        // step 2: n AND with NOT(bitmask)
        int n4 = 5; // Binary: 0101 — the number we want to inspect
        int pos4 = 2; // We want to check the bit at position 3 (counting from 0, right to left)

        int bitMask4 = 1 << pos4; // Shift 1 left by 'pos' bits → creates a mask like 1000 (binary)

        int newNumber4 = ~bitMask4 & n4;
        System.out.println(newNumber4);



    }
}

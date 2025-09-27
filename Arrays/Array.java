import java.util.Scanner;

public class Array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array");
        int size = sc.nextInt();

        int[] marks = new int[size];

        //int[] marks = {12,99,100};
        //marks[0] = 22;
        //marks[1] = 99;
        //marks[2] = 99;
        System.out.println("Enter values or no. into array");
        for(int i =0; i < size; i++){
            marks[i] = sc.nextInt();
        }

        System.out.println("give the no. which you want to find in the array");
        int x = sc.nextInt();

        for(int i =0; i < marks.length; i++){
            if (marks[i]==x) {
                System.out.println("The no. "+ x + " is found on the index " +i);
            }
        }
    }
}

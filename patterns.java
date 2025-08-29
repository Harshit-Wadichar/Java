import java.util.Scanner;

public class Patterns {
    public static void main(String[] args) {

        int n = 4;
        int m = 5;

        System.out.println("//to print a rectangle");

        //to print a rectangle
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print("*");
            }
            System.out.println(); // move to next line after finishing a row
        }

        System.out.println("//to print a hollow rectangle");

        //to print a hollow rectangle
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(i == 1 || j == 1 || i == n ||j == m){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println(); // move to next line after finishing a row
        }

        System.out.println("//to print a right-angle triangle");

        //to print a right-angle triangle
        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println(); // move to next line after finishing a row
        }

        System.out.println("//to print a right-angle triangle(upside down)");

        //to print a right-angle triangle(upside down)
        for(int i = n; i>=0; i--){
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("//to print a right-angle triangle(with space)");
        for(int i = 1; i<=n; i++){
            //to print space
            for(int k = 1; k<=n-i; k++){
                System.out.print(" ");
            }
            //to print stars
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("//To print right angle triangle of no.");
        for(int i = 1; i <=m; i++){
         for(int j =1; j <=i; j++){
             System.out.print(j);
         }
            System.out.println();
        }

        System.out.println("//To print inverted right angle triangle of no.");
        //first method
        for(int i = m; i >=1; i--){
            for(int j =1; j <=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        //second method
        for(int i = 1; i <=m; i++){
            for(int j =1; j <=m-i+1; j++){
                System.out.print(j);
            }
            System.out.println();
        }


        System.out.println("//To print right angle triangle of consistent increasing no.");
        int k = 1;
        for(int i = 1; i <=m; i++){
            for(int j =1; j <=i; j++){

                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        }

        System.out.println("//To print right angle triangle of 0's and 1's");

        for(int i = 1; i <=m; i++){
            for(int j =1; j <=i; j++){

                if((i+j)%2==0){
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
                }

            }
            System.out.println();
        }

        System.out.println("//To print solid rhombus");

        for (int i = 1; i <= m; i++) {
                    // Print leading spaces
            for (int j = 1; j <= m - i; j++) {
                System.out.print(" ");
                    }
                    // Print asterisks
                    for (int j = 1; j <= m; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
        }

        System.out.println("//To print a no. of pyramid");

        for (int i = 1; i <= m; i++) {
            // Print leading spaces
            for (int j = 1; j <= m - i; j++) {
                System.out.print(" ");
            }
            // Print repeated numbers
            for (int h = 1; h <= i; h++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("//To print palindromic number pyramid");

        for (int i = 1; i <= m; i++) {
            // Print leading spaces
            for (int j = 1; j <= m - i; j++) {
                System.out.print("  "); // Two spaces for better alignment
            }

            // Print descending numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            // Print ascending numbers (start from 2 to avoid repeating 1)
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        System.out.println("//advance patterns");
        System.out.println("//To print butterfly pattern ");

        for (int i = 1; i <= n; i++) {
            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*" ); // Two spaces for better alignment
            }
            int spaces = 2*(n-i);
            // Print spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*" ); // Two spaces for better alignment
            }
            int spaces = 2*(n-i);
            // Print spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }



    }
}

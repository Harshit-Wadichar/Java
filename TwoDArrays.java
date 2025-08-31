import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of rows of array");
        int rows = sc.nextInt();
        System.out.println("Enter the size of columns of array");
        int columns = sc.nextInt();

        int[][] twoDArray = new int[rows][columns];

        System.out.println("enter the values or elements in the array: ");
        //input
        for(int i =0; i<rows; i++){
            for(int j =0; j<columns; j++){
                twoDArray[i][j] = sc.nextInt();
            }
        }

        System.out.print("enter the no which you want to find in array : ");
        int x = sc.nextInt();

        //output
        for(int i =0; i<rows; i++){
            for(int j =0; j<columns; j++){
                System.out.print(twoDArray[i][j]+"");
            }
            System.out.println();
        }

        for(int i =0; i<rows; i++){
            for(int j =0; j<columns; j++){
               if(twoDArray[i][j]==x){
                   System.out.println("the no "+x+" is found at indices : " +i+" and "+j);
               }
            }
            System.out.println();
        }
    }
}

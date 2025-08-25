import java.util.Scanner;

public class Project {
    public static void main(String[] args){

        int randomNo = (int)(Math.random()*100);
        int userNo = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("guess a no between 1 to 100");

        do{
            System.out.println("enter your geuss no.");
            userNo = sc.nextInt();

            if(userNo==randomNo){
                System.out.println("wooo hooo! bro you have won");
                break;
            } else if (userNo>randomNo) {
                System.out.println("your entered no. is to big");
            } else {
                System.out.println("your entered no. is to small");
            }

        }
        while (userNo>=0);

        System.out.print("the guess no was: " + randomNo);

    }
}

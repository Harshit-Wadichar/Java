import java.util.Scanner;

public class Strings {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        String firstName = "Harshit";
        String lastName = "Wadichar";
        String fullName = firstName + " " + lastName;

        //length() function
        System.out.println(fullName.length());

        System.out.println("your name is "+ name);

        //charAt() function
        for(int i = 0; i< fullName.length(); i++){
            System.out.println(fullName.charAt(i));
        }

        // Compare
        String name1 = "Tony";
        String name2 = "Tony";

        // s1 > s2 : +ve value
        // s1 == s2 : 0
        // s1 < s2 : -ve value

        //if(name1.compareTo(name2) == 0){
        //    System.out.println("Strings are equal");
        //}
        //else{
        //    System.out.println("Strings are not equal");
        //}

        // if(name1 == name2) {
        //     System.out.println("Strings are equal");
        // } else {
        //     System.out.println("Strings are not equal");
        // }

        if(new String("Tony") == new String("Tony")) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are NOT equal");
        }

        //substring() function
        String scentence = "my name is harshit";
        String userName = scentence.substring(11,18);
        System.out.println(userName);

        //Strings are immutable which means a declared string can not be changed
    }
}

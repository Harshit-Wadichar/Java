public class Recursion1 {

    public static void printNum1(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printNum1(n-1);
    }

    public static void printNum2(int h){
        if(h==6){
            return;
        }
        System.out.println(h);
        printNum2(h+1);
    }

    public static void main(String[] args){
        int n = 5;
        printNum1(n);
        int h = 1;
        printNum2(h);

    }
}

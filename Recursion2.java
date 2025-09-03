public class Recursion2 {

    public static void towerOfHanoi(int n, String src,String helper, String dest ){
        if(n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        towerOfHanoi(n - 1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n - 1, helper, src, dest);
    }

    public static void printRev(String str, int idx){
        //to print a given string in reverse
        if (idx == 0) {
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.println(str.charAt(idx));
        printRev(str, idx-1);
    }

    public static int first = -1;
    public static int last =-1;

    public static void findOccurance(String str, int idx, char element){
        //to check the occurance of a charcter in a string (its first and last occurance)
         if(idx == str.length()){
             System.out.println("first : "+ first);
             System.out.println("last : "+ last);
             return;
         }
         char currChar = str.charAt(idx);
         if(currChar==element){
             if(first==-1){
                 first = idx;
             }
             else{
                 last = idx;
             }
         }
         findOccurance(str, idx+1, element);
    }

    public static boolean isSorted(int array[], int idx){
        //tocheck if a array is sorted or not in inreasing order or ascending order
        if(idx==array.length-1){
            return true;
        }
        if(array[idx]<array[idx+1]){
           return isSorted(array, idx+1);
        }
        else{
            return false;
        }

    }

    public static void main(String[] args){
        int n =3;
        towerOfHanoi(n, "S", "H", "D");

        String h = "harshit";
        printRev(h, h.length()-1);

        String str = "abaacdaefaah";
        findOccurance(str, 0, 'a');

        int array[] = {12,13,14,16};
        System.out.println(isSorted(array, 0));
    }
}

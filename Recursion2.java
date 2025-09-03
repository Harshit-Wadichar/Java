import java.util.HashSet;

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

    public static String moveAllX(String str, int idx, int count, String newString){
        //move the X present in the string to the last of the string
        if(idx==str.length()){
            for(int i =0; i<count; i++) {
                newString += "X";
            }
            return newString;
        }
        char currChar = str.charAt(idx);
        if(currChar == 'X'){
            count++;
            return moveAllX(str, idx+1, count, newString);
        }else{
            newString += currChar;
            return moveAllX(str, idx+1, count, newString);
        }
    }

    public static boolean map[] = new boolean[26];

    public static void removeDuplicates(String str, int idx, String newString){
        if(idx==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']==true){
            removeDuplicates(str, idx+1, newString);
        }
        else{
            newString+=currChar;
            map[currChar-'a']=true;
            removeDuplicates(str, idx+1, newString);
        }
    }

    public static void subsequences(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.err.println(newString);
            return;
        }

        char currChar = str.charAt(idx);

        // Include current character
        subsequences(str, idx + 1, newString + currChar);

        // Exclude current character
        subsequences(str, idx + 1, newString);
    }

    public static void uniqueSubsequences(String str, int idx, String newString, HashSet<String> set) {
        if (idx == str.length()) {
            if(set.contains(newString)){
                return;
            }else {
                set.add(newString);
                System.err.println(newString);
                return;
            }
        }

        char currChar = str.charAt(idx);

        // Include current character
        uniqueSubsequences(str, idx + 1, newString + currChar, set);

        // Exclude current character
        uniqueSubsequences(str, idx + 1, newString, set);
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

        String x = "haXrXshXiXt";
        System.out.println(moveAllX(x, 0, 0, ""));

        String rDuplicate = "takerevengebybecomingsuccessfull";
        removeDuplicates(rDuplicate, 0, "");

        String subsequence = "abc";
        subsequences(subsequence, 0, "");

        String uSubsequence = "aaa";
        HashSet<String> set = new HashSet<>();
        uniqueSubsequences(uSubsequence, 0, "", set);
    }
}

import java.util.ArrayList;

public class Recursion3 {

    public static void printPerm(String str, String permutation) {
        //print all permutations of a string
        if(str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPerm(newStr, permutation + currChar);
        }
    }

    public static int countPaths(int i, int j, int n, int m) {
        //count total paths in a maze to move from (0,0) to (n,m)
        if(i == n || j == m) {
            return 0;
        }
        if(i == n-1 && j == m-1) {
            return 1;
        }

        // move downwards
        int downPaths = countPaths(i+1, j, n, m);

        // move right
        int rightPaths = countPaths(i, j+1, n, m);

        return downPaths + rightPaths;
    }

    public static int placeTiles(int n, int m) {
        //function to know no. of ways a 1*m size tile can be placed at a floor where floor's size is n*m
        //when the floor becomes a square n==m there only remains two wy to place the tiles in the floor
        if(n == m) {
            return 2;
        }
        // we only can place in one way when n<m which is all horizontal
        if (n < m) {
            return 1;
        }

        // vertically
        int vertPlacements = placeTiles(n - m, m);

        // horizontally
        int horPlacements = placeTiles(n - 1, m);

        return vertPlacements + horPlacements;
    }

    public static int callGuests(int n) {
        /*
        This function calculates how many ways you can invite n guests to a party, where:
        - Each guest can come alone
        - Or come as a pair with another guest
        * */
        if(n <= 1) {
            return 1;
        }
        // single
        int ways1 = callGuests(n - 1);
        // pair
        int ways2 = (n - 1) * callGuests(n - 2);

        return ways1 + ways2;
    }

    public static void printSubset(ArrayList<Integer> subset) {
        //print all the subset of set of first n natural numbers
        for(int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }

    public static void findSubsets(int n, ArrayList<Integer> subset) {
        //find all the subset of set of first n natural numbers
        if(n == 0) {
            printSubset(subset);
            return;
        }

        // Case 1: Include n
        subset.add(n);
        findSubsets(n - 1, subset);

        // Case 2: Don't include n
        subset.remove(subset.size() - 1);
        findSubsets(n - 1, subset);
    }

    public static void main(String args[]) {
        String str = "abc";
        printPerm(str, "");

        int n = 3, m = 3;
        int totalPaths = countPaths(0, 0, n, m);
        System.out.println(totalPaths);

        int horizontalLengthM = 2;
        int verticalLengthN = 3;
        System.out.println(placeTiles(verticalLengthN, horizontalLengthM));

        int noOfPeople = 4;
        System.out.println(callGuests(noOfPeople));

        int nNaturalNo = 3;
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(nNaturalNo, subset);
    }
}

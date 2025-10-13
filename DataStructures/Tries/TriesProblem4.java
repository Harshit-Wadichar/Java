import java.util.*;

public class TriesProblem4 {
    static class Node {
        Node[] children = new Node[26];
        boolean eow;


        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }


    public static Node root = new Node();


    public static void insert(String word) { //O(n)
        int level = 0;
        int len = word.length();
        int idx = 0;


        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }


    public static boolean search(String key) { //O(n)
        int level = 0;
        int len = key.length();
        int idx = 0;


        Node curr = root;
        for (; level < len; level++) {
            idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static String ans = "";

    // to find longest word in a array which contains most of the words of the array as its prefixes
    public static void longestWord(Node root, StringBuilder curr) {

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                curr.append((char) (i + 'a'));
                if (curr.length() > ans.length()) {
                    ans = curr.toString();
                }
                longestWord(root.children[i], curr);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

    public static void main(String args[]) {
        String words[] = {"a", "banana", "ap", "app", "appl", "apply", "apple"};

        for (String word : words) {
            insert(word);
            System.out.println("inserted " + word);
        }

        longestWord(root, new StringBuilder());

        System.out.println(ans);
    }
}

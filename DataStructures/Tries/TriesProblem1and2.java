public class TriesProblem1and2 {
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

    //Question1: does the key when broken down creates most of the words present in the array?
    public static boolean wordBreak(String key) {
        int len = key.length();

        if (len == 0) {
            return true;
        }

        for (int i = 1; i <= len; i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    //Question2: Is the string is prefix of any word of the array?
    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String args[]) {
        String words[] = {"i", "like", "sam", "samsung", "mobile"};

        String key = "ilikesamsung";

        for (String word : words) {
            insert(word);
            System.out.println("inserted " + word);
        }

        System.out.println("does the key when broken down creates some words of array? ans:-" +wordBreak(key));

        String prefix = "sam";
        System.out.println("Does the prefix sam exist in any word of the array? ans:- "+startsWith(prefix));
        System.out.println("Does the prefix moon exist in any word of the array? ans:- "+startsWith("moon"));
    }
}



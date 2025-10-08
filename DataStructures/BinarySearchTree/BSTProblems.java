import java.util.ArrayList;

public class BSTProblems {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return search(root.right, key);
        }
    }

    //print elements of binary search tree in a range between x to y
    public static void printInRange(Node root, int x, int y){
        if(root==null){
            return;
        }
        if(root.data >=x && root.data <=y){
            printInRange(root.left, x, y);
            System.out.println(root.data + " ");
            printInRange(root.right,x,y);
        }
        else if(root.data >= y){
            printInRange(root.left, x, y);
        }
        else{
            printInRange(root.right, x, y);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i)+"--->");
        }
        System.out.print("null");
        System.out.println();
    }

    //To print all paths starting from root node to ending at leaf nodes
    public static void printRoot2leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        if(root.right == null && root.left == null){
            printPath(path);
        }
        else{
            printRoot2leaf(root.left, path);
            printRoot2leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i] );
        }

        // print inorder to verify tree (should print sorted order)
        System.out.println();
        inorder(root);

        System.out.println(search(root,9));

        printInRange(root, 1,3);

        printRoot2leaf(root, new ArrayList<>());
    }
}

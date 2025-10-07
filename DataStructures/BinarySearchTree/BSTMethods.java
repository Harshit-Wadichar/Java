public class BSTMethods {
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

    public static boolean search(Node root,int key){
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

    public static Node delete(Node root, int key){
        if(root ==null){
            return null;
        }
        if(root.data > key){
            root.left = delete(root.left, key);
        }
        else if(root.data<key){
            root.right = delete(root.right, key);
        }
        else{//root.data == key
            //case 1: the key do not have any child
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2: the key do have one child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3: the key have both childs
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
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
        delete(root, 2);
        inorder(root);


    }
}

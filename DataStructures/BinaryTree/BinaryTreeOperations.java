public class BinaryTreeOperations {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BinaryTree as an instance (no static index)
    static class BinaryTree {
        private int idx;

        public BinaryTree() {
            this.idx = -1;
        }

        // build tree from preorder-like array where -1 means null
        public Node buildTree(int[] nodes) {
            idx++;
            // safe-guard: if input finished, return null
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        // optional: reset if you want to reuse same BinaryTree object
        public void reset() {
            this.idx = -1;
        }
    }

    // return count of nodes
    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }


    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Diameter of Tree - Approach1 O(N^2)
    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }

        int diam1 = height(root.left) + height(root.right) + 1;
        int diam2 = diameter(root.left);
        int diam3 = diameter(root.right);

        return Math.max(diam1, Math.max(diam2, diam3));
    }

    public static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    //Diameter of Tree - Approach2 O(N)
    public static TreeInfo diameter2(Node root) {
        if(root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTI = diameter2(root.left);
        TreeInfo rightTI = diameter2(root.right);

        int myHeight = Math.max(leftTI.ht, rightTI.ht) + 1;

        int diam1 = leftTI.ht + rightTI.ht + 1;
        int diam2 = leftTI.diam;
        int diam3 = rightTI.diam;

        int myDiam = Math.max(diam1, Math.max(diam2, diam3));

        return new TreeInfo(myHeight, myDiam);
    }

    public static boolean isIdentical(Node root,Node subRoot){
        if(subRoot == null && root == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.data == subRoot.data){
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(isIdentical(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int subNode[] = {2, 4, -1, -1, 5, -1, -1};

        BinaryTree treeBuilder = new BinaryTree();
        BinaryTree treeBuilder2 = new BinaryTree();

        Node root = treeBuilder.buildTree(nodes);
        Node subNodeRoot = treeBuilder2.buildTree(subNode);

        System.out.println("Count of nodes: " + countOfNodes(root)); // expected: 6
        System.out.println("sum of nodes: " + sumOfNodes(root)); // expected: 21
        System.out.println("Height of nodes(levels): "+ height(root));
        System.out.println("Longest diameter of nodes (in O(n^2) approach): "+ diameter(root));
        System.out.println("Longest diameter of nodes (in O(n) approach): "+ diameter2(root).diam);
        System.out.println("is subNode exists in the big binary tree: "+ isSubtree(root,subNodeRoot) );
    }
}

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

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree treeBuilder = new BinaryTree();
        Node root = treeBuilder.buildTree(nodes);
        System.out.println("Count of nodes: " + countOfNodes(root)); // expected: 6
    }
}

# Binary Tree — README (for Java learners)

**Goal:** A single, easy-to-read guide that explains everything you need to understand binary trees and how to implement and use them in Java.

---

## Prerequisites

* Basic Java (classes, objects, recursion, arrays, collections).
* Comfortable reading simple code examples.

---

## What is a Binary Tree?

A **binary tree** is a tree data structure where each node has at most **two** children: commonly called the **left** child and the **right** child. Trees are hierarchical data structures — there is one special node called the **root**.

---

## Key Terms (quick reference)

| Term                     | Meaning                                                             | Note / Example                              |
| ------------------------ | ------------------------------------------------------------------- | ------------------------------------------- |
| Node                     | Basic element storing value and references to children              | `class Node { int val; Node left, right; }` |
| Root                     | Top node of the tree                                                | First node, no parent                       |
| Parent / Child           | Relationship between connected nodes                                | Root is parent of its immediate children    |
| Leaf                     | Node with no children                                               | `left == null && right == null`             |
| Internal node            | Node with at least one child                                        | Not a leaf                                  |
| Subtree                  | A node and all its descendants                                      | Every node is root of a subtree             |
| Depth (node)             | Number of edges from root to that node                              | Root depth = 0                              |
| Level                    | Depth + 1 (often)                                                   | Level of root = 1 (depending on convention) |
| Height (tree)            | Maximum depth among nodes                                           | Height of empty tree = -1 or 0 (specify)    |
| Degree                   | Number of children a node has (0,1,2)                               | Binary tree degree ≤ 2                      |
| Full Binary Tree         | Every node has 0 or 2 children                                      | No node has exactly one child               |
| Perfect Binary Tree      | All internal nodes have 2 children and all leaves same level        | Balanced and full                           |
| Complete Binary Tree     | Filled completely on every level except possibly last (left-packed) | Useful for array representation             |
| Skewed Tree              | Every node has only one child (left-skewed or right-skewed)         | Behaves like linked list                    |
| Binary Search Tree (BST) | Left subtree < node < right subtree (for keys)                      | Fast search/insert/delete on average        |

---

## Properties & Conventions

* Maximum nodes at level `l` = `2^(l-1)` (if root is level 1).
* Maximum nodes in a tree of height `h` = `2^(h+1) - 1` (height counted from 0).
* A complete binary tree is often stored in an array (heap-style) using indices.

---

## Diagrams (small examples)

1. Simple binary tree (root 1):

```
      1
     / \
    2   3
   / \   \
  4   5   6
```

2. BST example (inserting 8, 3, 10, 1, 6):

```
      8
     / \
    3   10
   / \
  1   6
```

---

## Representation in Java

### Node (basic)

```java
class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}
```

### Simple BinaryTree wrapper (non-BST) — building and printing

```java
public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Example: manual creation
    public void buildExample() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }
}
```

---

## Traversals (how to visit nodes)

Traversals let you visit all nodes in a systematic order.

### 1) Depth-first (recursive)

* **Preorder:** visit node, left, right  (`root -> left -> right`)
* **Inorder:** left, visit node, right (`left -> root -> right`)
* **Postorder:** left, right, visit node (`left -> right -> root`)

```java
// Recursive traversals
void preorder(Node n) {
    if (n == null) return;
    System.out.print(n.val + " ");
    preorder(n.left);
    preorder(n.right);
}

void inorder(Node n) {
    if (n == null) return;
    inorder(n.left);
    System.out.print(n.val + " ");
    inorder(n.right);
}

void postorder(Node n) {
    if (n == null) return;
    postorder(n.left);
    postorder(n.right);
    System.out.print(n.val + " ");
}
```

**Inorder of a BST gives sorted order of keys.**

### 2) Breadth-first / Level-order (uses a Queue)

Visit nodes level by level.

```java
void levelOrder(Node root) {
    if (root == null) return;
    Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
        Node cur = q.remove();
        System.out.print(cur.val + " ");
        if (cur.left != null) q.add(cur.left);
        if (cur.right != null) q.add(cur.right);
    }
}
```

### 3) Iterative inorder (stack)

```java
void inorderIterative(Node root) {
    Deque<Node> stack = new ArrayDeque<>();
    Node cur = root;
    while (cur != null || !stack.isEmpty()) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        System.out.print(cur.val + " ");
        cur = cur.right;
    }
}
```

---

## Binary Search Tree (BST) — brief

A BST is a binary tree with ordering property: all nodes in left subtree < node < all nodes in right subtree.

### BST Search (recursive)

```java
boolean search(Node root, int key) {
    if (root == null) return false;
    if (root.val == key) return true;
    return key < root.val ? search(root.left, key) : search(root.right, key);
}
```

### BST Insert (recursive)

```java
Node insert(Node root, int key) {
    if (root == null) return new Node(key);
    if (key < root.val) root.left = insert(root.left, key);
    else if (key > root.val) root.right = insert(root.right, key);
    // ignore duplicates or handle as needed
    return root;
}
```

### BST Delete (idea)

Three cases when deleting a node:

1. Leaf — just remove it.
2. One child — replace node with its child.
3. Two children — replace node with its inorder successor (smallest in right subtree) or inorder predecessor, then delete that successor.

(Implementation is slightly longer but follows the three-case pattern above.)

---

## Time & Space Complexity (common operations)

| Operation               | Binary Tree (general) | BST (average) | BST (worst-case) |
| ----------------------- | --------------------: | ------------: | ---------------: |
| Search                  |                  O(n) |      O(log n) |             O(n) |
| Insert                  |                  O(n) |      O(log n) |             O(n) |
| Delete                  |                  O(n) |      O(log n) |             O(n) |
| Traversals              |                  O(n) |          O(n) |             O(n) |
| Space (recursive depth) |                  O(h) |          O(h) |             O(n) |

`h` = tree height.

---

## Representations — array vs pointers

* **Pointer (node objects):** flexible, used for dynamic trees and BSTs.
* **Array:** used for complete trees / heap. Parent/child index math:

  * left child index = `2*i + 1`
  * right child index = `2*i + 2`
  * parent index = `(i-1)/2`

---

## Common mistakes & tips

* Decide whether tree height of empty tree is `-1` or `0` and be consistent.
* For recursion, always check `if (node == null) return;` first.
* Beware of integer duplicates in BST — decide how to treat equal keys.
* Use `Deque` (`ArrayDeque`) instead of `Stack` for stack operations.

---

## Practice problems (next steps)

* Implement tree traversals iteratively.
* Write `height(Node)` and `size(Node)` functions.
* Check if a tree is balanced (height difference <= 1 for all nodes).
* Convert sorted array to balanced BST.
* Serialize and deserialize a binary tree (string ↔ tree).

---

## Short checklist before an assignment / interview

* Can you draw and label root, leaves, levels?
* Can you write recursive inorder/preorder/postorder from memory?
* Do you understand BST insert/search/delete cases?
* Can you explain complexity and worst-case scenarios?

---

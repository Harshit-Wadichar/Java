# 🌳 Binary Search Tree (BST)

---

## ✨ Introduction

A **Binary Search Tree (BST)** is a structured binary tree that enables efficient lookup, insertion, and deletion of values. Its core idea is simple and powerful: every node’s left subtree contains values **less than** the node, and every node’s right subtree contains values **greater than** the node. This organization makes many operations fast and intuitive.

---

## 🌱 What is a Binary Search Tree?

* A BST is a binary tree with an ordering property: for any node `N`:

  * All values in `N`'s left subtree are **less** than `N`'s value.
  * All values in `N`'s right subtree are **greater** than `N`'s value.
* No duplicate values are stored (typical BST definition).
* An **in-order traversal** of a BST yields the elements in **sorted order**.

**Why BSTs matter:** they provide a middle ground between simple lists and fully-balanced search trees — giving fast average-case operations with straightforward structure and implementation.

---

## 🔎 Search in BST

**Conceptual steps for searching a value in a BST:**

1. Start at the root node.
2. Compare the search key with the current node’s value.
3. If equal → success. If smaller → continue with the left child. If larger → continue with the right child.
4. Repeat until the node is found or a null pointer is reached (not found).

**Key points:**

* Search exploits the ordering property; you discard half the tree at each step.
* Average time complexity: **O(log n)** (for roughly balanced trees).
* Worst-case time complexity: **O(n)** (for degenerate, chain-like trees).

---

## 🔨 Build a BST (Concept)

**Building a BST** means inserting values one-by-one while preserving the BST property. The typical flow:

* If the tree is empty, the new value becomes the root.
* Otherwise, compare the new value to the current node and move left or right accordingly until you find the correct empty position to insert.

**Practical considerations when building a BST:**

* The order of insertion affects the tree shape and hence performance.
* Randomized or balanced insertion strategies (e.g., AVL, Red-Black trees) can keep performance consistently good.

---

## 📁 Code for Building a BST

This project contains a ready-to-run implementation that constructs a BST from a sequence of values. The code focuses on:

* Accepting values as input (array, list, or interactive entry).
* Inserting each value while maintaining the BST property.
* Providing an interface to visualize or traverse the resulting tree.

*Usage tip:* the code exposes simple ways to add values and to print the structure for inspection.

---

## 🔍 Code for Search in BST

A companion implementation demonstrates how to search the BST for a target value and returns an indication of presence (or node reference, depending on your chosen interface).

* It shows how to start from the root and navigate left/right based on comparisons.
* It reports success/failure and optionally the path taken.

*Usage tip:* you can test search behavior by searching for existing and non-existing values to observe average vs. worst-case paths.

---

## ❌ Delete a Node in BST (Concept)

Deleting a node from a BST must be done carefully so the BST property remains intact. There are three conceptual cases to handle:

1. **Node is a leaf** (no children):

   * Simply remove the node.

2. **Node has one child:**

   * Replace the node with its single child so the subtree remains connected.

3. **Node has two children:**

   * Replace the node’s value with a value that preserves ordering — commonly the **in-order successor** (smallest value in the right subtree) or the **in-order predecessor** (largest value in the left subtree).
   * Remove the successor/predecessor from its original location (which now becomes a simpler deletion case).

**Key idea:** deletion transforms the problem into simpler sub-cases so the BST property holds after the operation.

---

## 🧰 Code for Deleting a Node in BST

The provided deletion code demonstrates the standard strategies for each of the three cases above and ensures the tree remains a valid BST after removal. The implementation includes:

* Safe handling of node references and child substitutions.
* Options to use in-order successor or predecessor when replacing nodes with two children.

*Usage tip:* try deleting nodes in different positions (leaf, internal with one child, internal with two children) and verify the tree’s in-order traversal remains sorted.

---

## 📐 Print in Range (Concept)

**Print in Range** is a common BST operation where you output all nodes whose values fall within a given interval `[low, high]`.

**Efficient strategy:**

* Traverse the tree while pruning branches that cannot contain valid values.

  * If current node value < `low` → skip left subtree (all smaller).
  * If current node value > `high` → skip right subtree (all greater).
  * Otherwise, the node is within range — include it and explore both sides where necessary.

**Why this is fast:** pruning avoids unnecessary traversal of subtrees that are out of bounds.

---

## 🧾 Code for Print in Range

A practical implementation is included which:

* Accepts `low` and `high` bounds.
* Traverses the BST and prints (or returns) all values inside the range in sorted order.

*Usage tip:* Test with ranges that are disjoint from your values, fully cover them, or partially overlap to fully exercise pruning logic.

---

## 🌿 Root-to-Leaf Paths (Concept)

**Root-to-Leaf Paths** are the sequences of nodes from the root down to each leaf node. Extracting all such paths is useful for:

* Enumerating complete value-chains stored by the tree.
* Computing path-based metrics (sum of path values, max path, etc.).
* Visualizing or exporting tree-shaped data in sequential form.

**Typical approach (conceptual):** perform a depth-first traversal while maintaining the current path; when you hit a leaf, record the path as one complete root-to-leaf route.

---

## 🗂️ Code for Root-to-Leaf Paths

The sample code collects all root-to-leaf paths and presents them as lists (or prints them). It includes:

* Recursive traversal keeping a temporary path structure.
* Safe backtracking once an explored path is recorded.

*Usage tip:* use the recorded paths to compute aggregates like path sums or to format the paths for display.

---

## ⚙️ Complexity Summary

| Operation          | Average Time | Worst Time |
| ------------------ | -----------: | ---------: |
| Search             |     O(log n) |       O(n) |
| Insert             |     O(log n) |       O(n) |
| Delete             |     O(log n) |       O(n) |
| In-order Traversal |         O(n) |       O(n) |

> Note: The logarithmic average assumes the tree stays relatively balanced. In degenerate cases (sorted input inserted without balancing), the tree becomes a chain and complexity degrades to linear.

---

## 💡 Practical Tips & Best Practices

* Insert values in random order (or use balancing trees) to avoid degenerate shapes.
* Use in-order traversal to **verify** correctness — it should produce a sorted sequence.
* When deleting nodes with two children, consistently choose successor or predecessor to simplify reasoning.
* For production-grade performance, consider self-balancing BSTs (AVL, Red-Black trees).

---

## 🏁 Final Notes

This README outlines the concepts and purposes behind core BST operations and accompanies a code collection that implements each behavior (building, searching, deleting, range printing, and root-to-leaf paths). It avoids step-by-step code narration and focuses on intuition, use cases, and verification tips.


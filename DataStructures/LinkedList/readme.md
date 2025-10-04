# Linked List

## What is a Linked List?

A **linked list** is a linear data structure where each element (called a *node*) stores data and a pointer/reference to the next node. Nodes are connected by these pointers, forming a chain. Unlike arrays, linked lists do not require contiguous memory and can grow or shrink easily.

---

## Visual depictions

### Singly linked list (simple)

```
head -> [ data | next ] -> [ data | next ] -> [ data | next ] -> null
```

Example with values 1 → 2 → 3:

```
head -> [ 1 | * ] -> [ 2 | * ] -> [ 3 | null ]
```

### Doubly linked list (each node points forward and backward)

```
null <- [ prev | data | next ] <-> [ prev | data | next ] <-> [ prev | data | next ] -> null
```

### Circular linked list (last node points back to head)

```
head -> [ 1 | * ] -> [ 2 | * ] -> [ 3 | * ]
              ^                       |
              |_______________________|
```

---

## Core operations (Singly Linked List)

| Operation          | What it does                  | Typical method name |               Time complexity |
| ------------------ | ----------------------------- | :-----------------: | ----------------------------: |
| Insert at head     | Add new node at beginning     |  `insertAtHead(x)`  |                          O(1) |
| Insert at tail     | Add new node at end           |  `insertAtTail(x)`  | O(n) (O(1) with tail pointer) |
| Insert at position | Add node at index `i`         | `insertAtPos(x, i)` |                          O(n) |
| Delete head        | Remove first node             |    `deleteHead()`   |                          O(1) |
| Delete by value    | Find & remove node with value |   `deleteValue(x)`  |                          O(n) |
| Search             | Find node with value          |     `search(x)`     |                          O(n) |
| Traverse           | Visit every node              |     `traverse()`    |                          O(n) |
| Reverse            | Reverse links in-place        |     `reverse()`     |                          O(n) |

---

## Why use a linked list?

* Dynamic size: easy to grow and shrink.
* Efficient insertions/deletions at the ends or middle (given references).
* Useful for implementing other structures: stacks, queues, adjacency lists.

When not to use: when you need O(1) random access by index — arrays or arraylists are better.

---

## Java example (simple singly linked list)

```java
class LinkedList {
    private class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    private Node head;

    public void insertAtHead(int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
    }

    public void insertAtTail(int x) {
        Node n = new Node(x);
        if (head == null) { head = n; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
    }

    public void traverse() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
```

---

## Reverse (idea)

1. Use three pointers: `prev = null`, `curr = head`, `next = null`.
2. Loop while `curr != null`: store `next = curr.next`, set `curr.next = prev`, move `prev = curr`, `curr = next`.
3. At the end, `prev` is new head. This reverses in-place with **O(n)** time and **O(1)** extra space.

---

## Step-by-step trace (insert & traverse)

Start: `head = null`

* `insertAtHead(1)` → `head -> [1]`
* `insertAtTail(2)` → `head -> [1] -> [2]`
* `insertAtTail(3)` → `head -> [1] -> [2] -> [3]`
* `traverse()` prints: `1 2 3`

---

## Complexity summary

* Access (by index): O(n)
* Insert/Delete at head: O(1)
* Insert/Delete at tail: O(n) unless tail pointer used (then O(1))
* Search: O(n)
* Space: O(n)

---

## Quick tips

* Maintain a `tail` pointer if you need frequent `insertAtTail` operations.
* For frequent random access, use arrays/ArrayList.
* For educational/debugging drawings, sketch nodes as boxes with arrows — show `head` clearly.

---


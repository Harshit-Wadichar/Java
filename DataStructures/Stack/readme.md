# Stack

## What is a Stack?

A **stack** is a linear data structure that follows **LIFO** (Last In, First Out). The last element pushed (inserted) into the stack is the first one to be popped (removed). Think of a stack of plates: you put new plates on the top and remove plates from the top.

---

## Visual depiction

Vertical view (top at the right):

```
Top -> [ 5 ]   <- top element (peek/pop)
       [ 4 ]
       [ 3 ]
       [ 2 ]
Bottom [ 1 ]
```

Horizontal compact view (bottom to top):

```
bottom [ 1, 2, 3, 4, 5 ] top
```

Operations act on the **top** of the stack.

---

## Core operations

| Operation  |                      What it does |   Typical name(s)  | Example behavior                                  |
| ---------- | --------------------------------: | :----------------: | ------------------------------------------------- |
| Push       |           Insert value at the top |      `push(x)`     | Stack `[1,2]` → `push(3)` → `[1,2,3]`             |
| Pop        |       Remove and return top value |       `pop()`      | `[1,2,3]` → `pop()` returns `3`, stack `[1,2]`    |
| Peek / Top | Return top value without removing | `peek()` / `top()` | `[1,2,3]` → `peek()` = `3`, stack still `[1,2,3]` |
| isEmpty    |           Check if stack is empty |     `isEmpty()`    | `[]` → `true`                                     |
| size       |                Number of elements |      `size()`      | `[1,2,3]` → `3`                                   |

---

## Time & space complexity

* **Push**: O(1)
* **Pop**: O(1)
* **Peek**: O(1)
* **Space**: O(n) to store `n` items

---

## When to use a stack

* Reversing data (temporarily store items and pop them later)
* Backtracking algorithms (e.g., DFS, undo history)
* Evaluating expressions (infix → postfix, postfix evaluation)
* Language parsing, function call stacks

---

## Example: Stack in Java

```java
import java.util.Stack;

Stack<Integer> s = new Stack<>();
s.push(1);
s.push(2);
s.push(3);
int top = s.peek(); // 3
int removed = s.pop(); // 3, stack is now [1,2]
```

## Example: Reverse a stack (idea)

1. Pop the top element until the stack becomes empty (recursively or iteratively).
2. Insert each popped element at the **bottom** of the stack while unwinding recursion.

This results in the original top elements becoming the bottom, reversing the order.

**Note:** A recursive reverse that uses a helper `pushAtBottom()` typically runs in **O(n²)** time and **O(n)** recursion space.

---

## Small step-by-step trace (push/pop example)

Starting stack: `[]`

* `push(1)` → `[1]`
* `push(2)` → `[1,2]`
* `push(3)` → `[1,2,3]`
* `pop()` → returns `3`, stack `[1,2]`
* `peek()` → returns `2`, stack unchanged

---

## Quick tips

* For most applications in Java, prefer `ArrayDeque<T>` as a stack instead of `Stack<T>` (synchronized) for better performance.
* When debugging, draw the stack vertically — it makes the top/bottom relation easier to follow.

---


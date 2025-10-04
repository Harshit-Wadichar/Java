# Queue in Java — Simple Explanation

This README focuses **only** on how a queue works, its basic operations, and short Java examples showing how to use the Queue data structure.

---

## What is a Queue?

A **queue** is a linear data structure that follows **FIFO** (First-In, First-Out) ordering: the first element added is the first element removed. Think of a real-world line (queue) where people join at the back and leave from the front.

## Core operations (what a queue can do)

* **Enqueue (add / offer):** Insert an element at the rear (tail) of the queue.

  * Java methods: `add(E e)` (throws exception on failure), `offer(E e)` (returns `false` if it can't add).

* **Dequeue (remove / poll):** Remove and return the element at the front (head) of the queue.

  * Java methods: `remove()` (throws `NoSuchElementException` if empty), `poll()` (returns `null` if empty).

* **Peek / inspect:** Look at the front element without removing it.

  * Java methods: `element()` (throws if empty), `peek()` (returns `null` if empty).

* **Utility operations:** `size()`, `isEmpty()`.

## Behavior and important notes

* **FIFO order** — elements leave in the same order they arrived.
* **Nulls:** Some implementations (e.g., `ArrayDeque`, `PriorityQueue`) do **not allow** `null`. `LinkedList` allows `null` elements. Use `poll()`/`peek()` safely when `null` may be returned.
* **Thread-safety:** Standard `Queue` implementations in `java.util` are **not** thread-safe. For multi-threaded use, prefer concurrent or blocking queues from `java.util.concurrent`.

## Short Java examples

> Two minimal examples showing how to use a queue in Java.

### 1) Using `LinkedList` (works in older Java versions and allows `null`)

```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueExampleLinkedList {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>(); // explicit type for older compilers
        q.add(10); // enqueue
        q.add(20);

        System.out.println(q.peek()); // prints 10, does not remove
        System.out.println(q.remove()); // removes and prints 10
        System.out.println(q.poll()); // removes and prints 20
    }
}
```

### 2) Using `ArrayDeque` (recommended for pure queue usage — faster, no nulls)

```java
import java.util.Queue;
import java.util.ArrayDeque;

public class QueueExampleArrayDeque {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>(); // diamond operator OK in Java 7+
        q.offer(1); // safer enqueue (returns false on failure)
        q.offer(2);

        while (!q.isEmpty()) {
            Integer front = q.poll(); // removes and returns front or null if empty
            System.out.println(front);
        }
    }
}
```

## When to use which implementation (quick guidance)

* Use **`ArrayDeque`** for most single-threaded queue needs — it's fast and efficient.
* Use **`LinkedList`** if you need list features or need to allow `null` values.
* Use **`PriorityQueue`** when you need elements ordered by priority rather than FIFO.
* For concurrent programs, use queues from `java.util.concurrent` (e.g., `ConcurrentLinkedQueue`, `ArrayBlockingQueue`).

---

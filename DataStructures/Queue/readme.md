# Queue in Java

> A concise README explaining the Queue interface, common implementations, examples, differences, and best practices.

---

## Table of contents

1. What is a Queue?
2. Properties of a Queue
3. The `Queue` interface (commonly used methods)
4. Common implementations

   * `LinkedList`
   * `ArrayDeque`
   * `PriorityQueue`
   * `ArrayBlockingQueue` and `ConcurrentLinkedQueue` (concurrency)
5. Example code (LinkedList and ArrayDeque)
6. Visualizations (ASCII)
7. Performance / Complexity
8. Common pitfalls and best practices
9. When to use which implementation
10. How to compile & run example

---

## 1. What is a Queue?

A **queue** is a linear data structure that follows **FIFO** (First-In, First-Out) ordering: elements are added at the rear (tail) and removed from the front (head). In Java, `Queue` is an interface in `java.util` that describes queue behavior.

## 2. Properties of a Queue

* **FIFO** ordering by default (except `PriorityQueue`, which orders by priority).
* Allows operations to add, inspect, and remove elements.
* Implementations differ in memory layout, performance, and thread-safety.

## 3. The `Queue` interface (commonly used methods)

```java
boolean add(E e)       // throws exception if capacity-limited and full
boolean offer(E e)     // returns false if capacity-limited and full
E remove()             // throws NoSuchElementException if empty
E poll()               // returns null if empty
E element()            // throws NoSuchElementException if empty
E peek()               // returns null if empty
int size()
boolean isEmpty()
```

Notes:

* `add`/`remove` throw exceptions for error conditions; `offer`/`poll`/`peek` are safer alternatives that return special values.

## 4. Common implementations

### `LinkedList<E>`

* Backed by a doubly linked list.
* Implements `List`, `Deque`, and `Queue`.
* Allows `null` elements.
* Good when you need list-like operations as well.

### `ArrayDeque<E>`

* Resizable circular array (ring buffer) implementation that implements `Deque` and `Queue`.
* Usually **faster** than `LinkedList` for queue operations due to better cache locality and lower memory overhead.
* **Does NOT allow `null`** elements.
* Recommended for general-purpose queue/deque usage.

### `PriorityQueue<E>`

* Not FIFO — elements are ordered by natural ordering or provided comparator.
* Useful when you need to process elements by priority.

### Concurrent / Blocking queues (brief)

* `ArrayBlockingQueue<E>` — bounded blocking queue useful for producer-consumer patterns.
* `LinkedBlockingQueue<E>` — optionally bounded, blocking.
* `ConcurrentLinkedQueue<E>` — non-blocking, thread-safe queue.

## 5. Example code

### Example 1 — `LinkedList` as Queue (works in all Java versions)

```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueExampleLinkedList {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek()); // inspect
            q.remove();                   // remove
        }
    }
}
```

### Example 2 — `ArrayDeque` as Queue (preferred for speed)

```java
import java.util.Queue;
import java.util.ArrayDeque;

public class QueueExampleArrayDeque {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        while (!q.isEmpty()) {
            System.out.println(q.poll()); // poll removes and returns or null if empty
        }
    }
}
```

### Example 3 — `PriorityQueue`

```java
import java.util.PriorityQueue;

PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(5);
pq.add(1);
pq.add(3);
// poll() returns smallest element first (natural order)
```

## 6. Visualizations (ASCII)

**LinkedList-backed queue**

```
head -> [1] <-> [2] <-> [3] <- tail
peek() returns value at head (1)
remove() removes head node
```

**ArrayDeque (circular buffer) example (capacity 5)**

```
index: 0 1 2 3 4
array: 6 7 3 4 5
front -> index 2 (value 3)
rear  -> index 1 (value 7)
add: rear = (rear + 1) % capacity
remove: front = (front + 1) % capacity
```

## 7. Performance / Complexity (typical)

* `add` / `offer` : O(1) amortized
* `remove` / `poll` : O(1)
* `peek` / `element` : O(1)
* `ArrayDeque` tends to be faster in practice due to contiguous memory and fewer allocations.

## 8. Common pitfalls and best practices

* **Nulls**: `ArrayDeque` and `PriorityQueue` do not permit `null` elements. `LinkedList` allows them — be careful when `poll()` returns `null` (empty) vs `null` as a stored value.
* **Diamond operator**: `new ArrayDeque<>()` requires Java 7+. If using an older compiler, use `new ArrayDeque<Integer>()` explicit type.
* **Name conflicts**: If you create your own `LinkedList` class, it can shadow `java.util.LinkedList`. Fully qualify `java.util.LinkedList` if necessary.
* **Thread-safety**: `LinkedList`, `ArrayDeque`, and `PriorityQueue` are **not thread-safe**. Use concurrent collections (`ConcurrentLinkedQueue`, `BlockingQueue`) when needed.

## 9. When to use which implementation

* Use **`ArrayDeque`** for most single-threaded queue/deque use cases — fast and memory-efficient.
* Use **`LinkedList`** if you need list operations (insert/remove in middle) or you need `null` values.
* Use **`PriorityQueue`** when you need priority ordering instead of FIFO.
* Use **concurrent/blocking queues** for producer-consumer or multi-threading.

## 10. How to compile & run example

Save a file `QueueExampleArrayDeque.java` then:

```bash
javac QueueExampleArrayDeque.java
java QueueExampleArrayDeque
```

---


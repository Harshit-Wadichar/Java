# Java Collection Framework (JCF)

The **Java Collection Framework (JCF)** is a set of classes and interfaces that make it easy to **store, manage, and process groups of objects**. Instead of writing your own data structures, Java gives ready-made ones like **List**, **Set**, **Queue**, **Deque**, and **Map**.

---

## Why use Java Collections?

* Store multiple objects in a single unit.
* Dynamic in size (unlike arrays).
* Provides ready-to-use data structures (stack, queue, linked list, etc.).
* Built-in methods for searching, sorting, inserting, deleting.
* Increases code reusability and efficiency.

---

## Collection Hierarchy (simple view)

```
          Iterable
             |
         Collection
       /     |     \
     List   Set    Queue
     
     Map (separate interface, not child of Collection)
```

---

## Important Interfaces in JCF

### 1. Iterable

* The root interface for collections that can be iterated.
* Allows iteration using `Iterator` or the `for-each` loop.
* **Method:** `iterator()`

### 2. Collection

* Base interface for almost all collection classes (except `Map`).
* **Common methods:**

  * `add(E e)` → Add element
  * `remove(Object o)` → Remove element
  * `clear()` → Remove all elements
  * `size()` → Number of elements
  * `isEmpty()` → Check if empty
  * `contains(Object o)` → Check if an element exists
  * `iterator()` → Get an iterator

### 3. List (ordered collection, allows duplicates)

* Classes: `ArrayList`, `LinkedList`, `Vector`, `Stack`
* Extra methods:

  * `get(int index)` → Get element by index
  * `set(int index, E e)` → Replace element
  * `indexOf(Object o)` → First index of element
  * `lastIndexOf(Object o)` → Last index of element
  * `subList(int from, int to)` → Portion of the list

### 4. Set (no duplicates, usually unordered)

* Classes: `HashSet`, `LinkedHashSet`, `TreeSet`
* Uses `Collection` methods; does not allow duplicate elements.
* `TreeSet` keeps elements in sorted order.

### 5. Queue (FIFO — first in, first out)

* Classes: `PriorityQueue`, `LinkedList` (as Queue), `ArrayDeque`
* Extra methods:

  * `offer(E e)` → Add element (returns `false` if it fails)
  * `poll()` → Remove and return the head (or `null` if empty)
  * `peek()` → Get head without removing (or `null` if empty)
  * `element()` → Like `peek()` but throws exception if empty

### 6. Deque (double-ended queue — add/remove from both ends)

* Classes: `ArrayDeque`, `LinkedList`
* Extra methods:

  * `addFirst(E e)` / `addLast(E e)`
  * `removeFirst()` / `removeLast()`
  * `peekFirst()` / `peekLast()`

### 7. Map (key → value pairs)

* `Map` is not a subinterface of `Collection` but is part of the framework.
* Classes: `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`
* Important methods:

  * `put(K key, V value)` → Insert or update a key-value pair
  * `get(Object key)` → Get value for a key
  * `remove(Object key)` → Remove key and its value
  * `containsKey(Object key)`
  * `containsValue(Object value)`
  * `keySet()` → Get all keys
  * `values()` → Get all values
  * `entrySet()` → Get all key-value pairs as `Map.Entry`

---

## Quick Summary Table

| Interface | Allows Duplicates       | Ordered                   | Null Allowed                                               | Examples                  |
| --------- | ----------------------- | ------------------------- | ---------------------------------------------------------- | ------------------------- |
| List      | Yes                     | Yes                       | Yes                                                        | ArrayList, LinkedList     |
| Set       | No                      | Depends                   | Usually one `null` allowed (HashSet)                       | HashSet, TreeSet          |
| Queue     | Sometimes               | Yes                       | Yes                                                        | PriorityQueue, LinkedList |
| Deque     | Yes                     | Yes                       | Yes                                                        | ArrayDeque                |
| Map       | Keys - No, Values - Yes | Depends on implementation | `HashMap` allows one `null` key and multiple `null` values | HashMap, TreeMap          |

---

## Example Code

```java
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // List Example
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple"); // allows duplicates
        System.out.println("List: " + list);

        // Set Example
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // ignored, no duplicates
        System.out.println("Set: " + set);

        // Queue Example
        Queue<String> queue = new LinkedList<>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        System.out.println("Queue poll: " + queue.poll());

        // Map Example
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Red");
        map.put(2, "Blue");
        map.put(3, "Green");
        System.out.println("Map: " + map);
    }
}
```

---

## Notes & Tips

* Choose `List` when order matters and duplicates are allowed.
* Choose `Set` when duplicates must be prevented.
* Use `Queue`/`Deque` for FIFO or double-ended operations.
* Use `Map` when storing key-value pairs.
* `ArrayList` is good for fast random access. `LinkedList` is better for many insertions/removals inside the list.
* `HashMap` is fast for key-based access; `TreeMap` keeps keys sorted.

---


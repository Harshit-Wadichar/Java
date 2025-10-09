# 🧠 Hash Table, HashMap & HashSet — Quick Guide

---

## 🚀 Overview

This guide explains:

* What a **Hash Table** is and why it’s fast.
* How **`HashMap`** implements a hash table for key–value storage.
* How **`HashSet`** uses `HashMap` internally to store unique values.

It includes visualizations, Java examples, an internal-working section and a tidy summary table.

---

## 📚 Table of Contents

1. [Hash Table (Concept)](#hash-table-concept)
2. [HashMap — Java Implementation](#hashmap---java-implementation)
3. [HashSet — Java Implementation](#hashset---java-implementation)
4. [Visualization — Buckets & Collisions](#visualization--buckets--collisions)
5. [Summary Table](#summary-table)
6. [Quick Notes & Tips](#quick-notes--tips)

---

## 🔹 Hash Table (Concept)

A **Hash Table** stores data in **key–value pairs** and uses a **hash function** to convert a key into an **index** (the *hash code*). That index decides **where** the element will be stored in the underlying array (buckets).

### ✨ Key Features

* ⚡ **Fast** insertion, deletion and lookup — average **O(1)**.
* 🪣 Uses **buckets** and handles collisions with **linked lists** or **trees**.
* 📈 **Resizes automatically** when load factor is exceeded.

---

## 🌿 HashMap — Java Implementation

**Implements:** `Map<K, V>`

**Data Structure Used:** Hash Table

**Stores:** Key–Value pairs

**Duplicates:** Keys ❌ (unique) | Values ✅ (allowed)

**Order:** Unordered (depends on hash codes)

### ✅ Example

```java
import java.util.*;
class Example {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        System.out.println(map);
    }
}
```

> Internally, `HashMap` stores `Map.Entry` objects in an **array of buckets**. Each bucket may contain a **linked list** (or a **Red-Black tree** for large chains).

---

## 🍀 HashSet — Java Implementation

**Implements:** `Set<E>`

**Data Structure Used:** Hash Table (via `HashMap` internally)

**Stores:** Only values (each element is stored as a key internally)

**Duplicates:** ❌ Not allowed

**Order:** Unordered

### ✅ Example

```java
import java.util.*;
class Example {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("C++");
        set.add("Python");
        System.out.println(set);
    }
}
```

### 🔧 Internal Working

```java
// simplified internal view
HashMap<E, Object> map = new HashMap<>();
private static final Object PRESENT = new Object();

// when you do:
set.add("Java");
// internally ->
map.put("Java", PRESENT);
```

---

## 🧩 Visualization — Buckets & Collisions

```
Hash Table (Array of Buckets)
----------------------------------
Index | Elements
----------------------------------
0     | [key1 -> value1]
1     | [key2 -> value2]
2     | [key3 -> value3]
3     | [key4 -> value4]
```

If two keys produce the same hash index → they go into the same **bucket** (collision).
Collision handling in Java:

* For short chains: **LinkedList** of entries
* For long chains: converted to a **Red-Black Tree** (improves worst-case lookup)

---

## 🧮 Summary Table

| Feature             |                      HashSet |                      HashMap |
| ------------------- | ---------------------------: | ---------------------------: |
| Implements          |                     `Set<E>` |                   `Map<K,V>` |
| Data Structure Used |     Hash Table (via HashMap) |                   Hash Table |
| Stores              |                  Only values |              Key–Value pairs |
| Duplicates          |                ❌ Not allowed |             Keys ❌, Values ✅ |
| Order Maintained    |                         ❌ No |                         ❌ No |
| Collision Handling  | Linked List / Red-Black Tree | Linked List / Red-Black Tree |

---

## 💡 Quick Notes & Tips

* Use `HashMap` when you need key→value lookup.
* Use `HashSet` when you only need **unique** values.
* If you need ordering: consider `LinkedHashMap` / `LinkedHashSet` (insertion order) or `TreeMap` / `TreeSet` (sorted order).
* Keep an eye on **load factor** and **initial capacity** if performance matters for large datasets.

---

## 📜 License

This README is free to use and adapt — attribution appreciated but not required. ❤️

---

*Happy hashing!* ✨

# Trie (Prefix Tree) — README

## What is a Trie?

A **Trie** (pronounced "try"), also called a **prefix tree**, is a tree-like data structure that stores a dynamic set of strings where keys are usually strings. Each node represents a single character of a key. Words with common prefixes share the same path from the root.

Tries are optimized for retrieval of keys based on prefixes — e.g., auto-complete, spell-check, and dictionary implementations.

---

## Quick diagram (ASCII)

```
Root
 |
 +- 'c' -- 'a' -- 't' (isEnd)
 |                
 |                
 +- 'c' -- 'a' -- 'r' (isEnd)
 |
 +- 'b' -- 'a' -- 't' (isEnd)
```

A clearer view (branching):

```
          (root)
          /   \
        c       b
       / \      \
      a   a      a
     /     \      \
    t*      r*    t*

* = node marks end-of-word
```

In this example the trie stores: `cat`, `car`, `bat`.

---

## Main characteristics

* **Prefix sharing:** Common prefixes are stored once, saving duplication.
* **Fast lookups by prefix:** Finding all words with a given prefix is efficient.
* **Character-indexed children:** Each node usually has an array or map of children; arrays are faster but use more memory when alphabet is large.
* **Space vs time tradeoff:** Tries use more memory than hash-based structures for many small keys, but give better guarantees for prefix operations.
* **Order-insensitive with respect to insertion time:** Time complexity depends on key length, not number of keys.

---

## Core operations and their time complexities

All complexities below assume the length of the input string/key is `L`, and the alphabet size is `A` (for lowercase English letters, `A = 26`).

| Operation                  | Time Complexity | Explanation                                                                        |
| -------------------------- | --------------: | ---------------------------------------------------------------------------------- |
| Insert                     |            O(L) | Walk/create L nodes (one per character).                                           |
| Search (exact)             |            O(L) | Walk L nodes and check `isEnd`.                                                    |
| StartsWith / Prefix search |        O(L + K) | Walk L nodes to reach prefix, then optionally traverse K nodes to collect matches. |
| Delete                     |            O(L) | Walk L nodes and remove nodes if they are no longer needed (may use recursion).    |

**Notes:** These are per-key complexities — they do **not** depend directly on the number of keys `N` stored in the trie (except when collecting many matches after a prefix search).

---

## Space complexity

* **Worst-case (simple view):** O(A × L × N) — where `N` is number of keys and `L` is average key length, `A` is alphabet size. This comes from representing children arrays of size `A` at many nodes.
* **Tighter view:** O(total number of nodes). Each node stores: pointers for children (or a map), and a boolean `isEnd`. The number of nodes ≤ sum of lengths of all inserted keys.

In practice:

* Using an array `Node[] children = new Node[A]` gives O(A) pointers per node (fast but memory-heavy).
* Using a `Map<Character, Node>` (like `HashMap`) reduces memory for sparse nodes at the cost of somewhat slower access.

---

## When to use a Trie

* Auto-complete and search suggestions
* Spell-checking and dictionary implementations
* IP routing (when keys are binary strings)
* When you need prefix-based queries with predictable O(L) time

## When not to use a Trie

* If memory is tight and keys are short and few — a hash set or sorted array may be simpler.
* When alphabet is huge and sparse; use compressed trie, Ternary Search Tree, or maps instead.

---

## Variants and optimizations (short)

* **Compressed trie (Radix tree / Patricia trie):** merges single-child chains to save space.
* **Ternary Search Tree:** uses three pointers per node (less memory than full array for large alphabets).
* **Using HashMap children:** `Map<Character, Node>` stores only existing edges, saving memory for sparse tries.

---

## Summary

* Trie is a prefix tree excellent for problems involving prefixes and dictionary operations.
* Time complexity for inserts/search/delete is O(L) (L = length of key).
* Space cost can be high; choose child representation (array vs map) depending on alphabet and memory constraints.

---

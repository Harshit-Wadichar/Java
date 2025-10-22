# Graph Data Structures in Java — A Simple Guide

## Overview

This README explains graphs in a simple, step-by-step way so you can build strong intuition before writing code. It covers:

* What a graph is and common terms
* Ways to represent graphs in Java (conceptually, without code)
* Traversals: BFS and DFS
* Connected components, bridges, and articulation points
* Topological sort and cycles in graphs
* Strongly Connected Components (Kosaraju's and Tarjan's algorithms)
* Shortest path algorithms (Dijkstra, Bellman–Ford)
* Minimum Spanning Tree algorithms (Prim’s, Kruskal’s)
* Other important graph concepts and quick references

Each topic is explained in plain language, with motivations and where it is used. No code — just clear concepts so the ideas are easy to remember.

---

# 1. What is a Graph?

A **graph** is a collection of **nodes** (also called *vertices*) and **edges** (connections between nodes). Graphs model relationships: cities connected by roads, friends connected on social media, web pages linked by hyperlinks, etc.

* **Vertex (node):** A single point in the graph.
* **Edge:** A connection between two vertices.
* **Directed graph (digraph):** Edges have a direction (A → B). Useful for one-way relationships.
* **Undirected graph:** Edges are two-way (A ↔ B).
* **Weighted graph:** Each edge has a number (weight) like distance, cost, or time.
* **Unweighted graph:** Edges are equal; no weights.

Important simple terms:

* **Path:** A sequence of vertices connected by edges.
* **Cycle:** A path where the start and end vertex are the same and at least one edge exists.
* **Degree:** Number of edges attached to a vertex (in directed graphs: in-degree and out-degree).
* **Connected graph:** In an undirected graph, if every pair of vertices has a path between them.
* **DAG (Directed Acyclic Graph):** A directed graph with no cycles.

---

# 2. Ways to Represent Graphs in Java (Conceptual)

There are three common ways to represent a graph. Each has tradeoffs.

## Adjacency List (most common)

* For each vertex, store a list of its neighbors.
* Good when the graph is **sparse** (few edges).
* Memory: O(V + E).
* In Java you would conceptually use: an array or `List` of `List`s, or a `Map<Vertex, List<Vertex>>`.

## Adjacency Matrix

* A 2D matrix `V x V` where `matrix[i][j] = 1` (or weight) if an edge exists.
* Good when the graph is **dense** (many edges) or when you need constant-time edge checks.
* Memory: O(V^2) — expensive for large V.

## Edge List

* Store a list of edges `(u, v, weight)`.
* Very simple and useful for algorithms that process edges directly (e.g., Bellman–Ford, Kruskal).
* Memory: O(E).

**Which to use in Java?**

* Use adjacency lists for most general-purpose graph problems.
* Use adjacency matrix for small graphs or when you need O(1) edge checks.
* Use edge list when you need to iterate over edges or sort edges (e.g., Kruskal).

---

# 3. Graph Traversals: BFS and DFS

Traversals are ways to visit all nodes in a graph. They are building blocks for many algorithms.

## Breadth-First Search (BFS)

* Visits nodes level by level, starting from a source node.
* Uses a **queue** internally.
* Distance in an unweighted graph: BFS finds the shortest path (fewest edges) from the source to all reachable nodes.
* Typical uses: shortest path in unweighted graphs, level-order exploration, checking bipartiteness.
* Time: O(V + E).

**Idea in simple words:** Start from the source, visit all neighbors (distance 1), then their neighbors (distance 2), and so on — like ripples from a stone thrown in water.

## Depth-First Search (DFS)

* Explores as far as possible along one branch before backtracking.
* Uses a **stack** (explicit or call stack via recursion).
* Typical uses: topological sort, finding connected components, detecting cycles, and some path-finding variants.
* Time: O(V + E).

**Idea in simple words:** Follow a path until you cannot go further, then step back (backtrack) and try other paths.

---

# 4. Connected Components

* In an **undirected** graph, a **connected component** is a set of vertices where each vertex is reachable from every other vertex in the set.
* Use DFS or BFS to find all connected components: run DFS/BFS from an unvisited node, mark all reachable nodes — that group is one component. Repeat until all nodes are visited.
* This is useful to see how many separate "islands" exist in the graph.

---

# 5. Bridges and Articulation Points (Cut Vertices)

* A **bridge** is an edge that, if removed, increases the number of connected components (it disconnects part of the graph).
* An **articulation point** (cut vertex) is a vertex that, when removed (with its edges), increases the number of connected components.

**Why important?** Bridges and articulation points identify weak links in networks — removing them causes disconnection.

**How to find them (conceptual):**

* Use a DFS traversal and compute **discovery times** and **low-link values** for each node:

  * `discovery[u]`: time when `u` is first visited.
  * `low[u]`: earliest discovery time reachable from `u` by following zero or more tree edges and at most one back edge.
* If for an edge `u - v` (where `u` is parent of `v` in DFS tree) we have `low[v] > discovery[u]`, then `u - v` is a bridge.
* Similar rules help find articulation points.

Tarjan’s approach (low-link) is the standard method behind both bridge-finding and SCC-finding (discussed next).

---

# 6. Topological Sort

* Works for **DAGs** (directed acyclic graphs).
* A **topological order** is a linear ordering of vertices such that for every directed edge `u → v`, `u` comes before `v`.

**Why useful?** Scheduling tasks with dependencies (build systems, course prerequisites, etc.).

**How (conceptual): Two common ways**

1. **Kahn’s algorithm (BFS-like):** Repeatedly remove nodes with in-degree 0 and append them to the order; reduce in-degrees of neighbors.
2. **DFS-based:** Run DFS and push nodes onto a stack when finished; popping stack gives topological order.

If the graph has a cycle, topological sort is impossible.

---

# 7. Finding Cycles

Detecting cycles is important for correctness checks and algorithms (like topological sort).

## Directed Graphs

* Use DFS with a **recursion stack** (or color marking).
* When visiting a neighbor, if it is on the current recursion stack, you found a back edge → cycle exists.
* Alternatively, use Kahn’s algorithm: if Kahn’s algorithm doesn’t process all nodes (some remain due to positive in-degrees), the graph has a cycle.

## Undirected Graphs

* Use DFS: if you find an adjacent vertex that is visited and is not the parent of the current node, there's a cycle.
* Another method: Union-Find (Disjoint Set Union) while processing edges — if two vertices of an edge are already in the same set, adding this edge creates a cycle.

---

# 8. Strongly Connected Components (SCC)

* In a **directed** graph, an SCC is a maximal set of vertices where each vertex is reachable from every other vertex in the set.

**Two common algorithms:**

## Kosaraju’s Algorithm (conceptually)

1. Run DFS on the original graph and keep nodes in a list ordered by finish times (or push finished nodes onto a stack).
2. Reverse all edges of the graph (transpose graph).
3. Process nodes in decreasing finish-time order: for each unvisited node, run DFS on the transposed graph — the visited nodes form one SCC.

Kosaraju is simple and uses two passes of DFS.

## Tarjan’s Algorithm (conceptually)

* Runs a single DFS and uses a stack to collect nodes of the current SCC.
* Maintains discovery time and low-link values; when a node’s discovery time equals its low-link value, it is the root of an SCC. Pop the stack until that node to get the whole SCC.
* Tarjan is more efficient in practice because it uses one pass.

Both algorithms produce the same SCCs but use different techniques (Kosaraju: two passes + transpose; Tarjan: single pass + stack + low-link).

---

# 9. Shortest Path Algorithms

When graphs have weights (like distances or costs), we often want the shortest path.

## Dijkstra’s Algorithm (for non-negative weights)

* Finds shortest paths from a source to all vertices when all edge weights are non-negative.
* Concept: greedily pick the vertex with smallest known distance from the source, relax its outgoing edges (update distances), and repeat using a min-priority queue.
* Time with binary heap: O((V + E) log V).

**Limitation:** Cannot handle negative weight edges.

## Bellman–Ford Algorithm (handles negative edges)

* Works even if some edges have negative weights; detects negative cycles reachable from the source.
* Concept: Relax all edges V-1 times (where V is number of vertices). If you can relax any edge on the V-th iteration, there is a negative weight cycle.
* Time: O(V * E) — slower than Dijkstra but more general.

**Use Bellman–Ford** when negative weights are possible and you need to detect negative cycles.

---

# 10. Minimum Spanning Tree (MST)

An MST of a connected, undirected, weighted graph is a subset of edges that connects all vertices with the minimum total weight and without cycles.

**Two popular algorithms to find MSTs:**

## Prim’s Algorithm (conceptual)

* Start from any node, grow a tree by repeatedly adding the smallest weight edge that connects a vertex in the tree to a vertex outside the tree.
* Use a priority queue keyed by the minimum edge weight to each outside vertex.
* Time: O(E log V) with a binary heap.

## Kruskal’s Algorithm (conceptual)

* Sort all edges by weight and add them one by one if they don’t create a cycle (use Union-Find to check).
* Continue until you have V-1 edges.
* Time: O(E log E) mostly dominated by sorting.

Both produce the same MST for graphs with unique edge weights or when tie-breaking is arbitrary.

---

# 11. Other Important Terms (Quick Glossary)

* **Degree (undirected):** number of edges incident to a vertex.
* **In-degree / Out-degree:** for directed graphs.
* **Path length:** number of edges in the path or sum of weights (for weighted graphs).
* **Simple path:** a path with no repeated vertices.
* **Subgraph:** a graph made from a subset of vertices and edges of the original graph.
* **Cut:** a partition of vertices into two disjoint sets; edges crossing the partition are cut edges.
* **Cut-edge / Bridge:** an edge whose removal increases number of connected components.
* **Spanning Tree:** a tree connecting all vertices of a connected graph.
* **Eulerian Path / Circuit:** a path or circuit that visits every edge exactly once.
* **Hamiltonian Path / Cycle:** a path or cycle that visits every vertex exactly once (hard to find generally).

---

# 12. Order of Topics for Learning (recommended)

1. Basic definitions: vertices, edges, types (directed/undirected), weighted/unweighted.
2. Representations: adjacency list vs matrix vs edge list.
3. Simple traversals: BFS and DFS (practice both by hand).
4. Connected components (undirected graphs) and basic graph properties.
5. Cycle detection methods (directed and undirected).
6. Topological sort and DAG properties.
7. Bridges and articulation points (DFS low-link ideas).
8. Strongly Connected Components: Kosaraju and Tarjan (understand finish times and low-link).
9. Shortest paths: Dijkstra (non-negative) and Bellman–Ford (negative edges).
10. Minimum spanning trees: Prim’s and Kruskal’s (greedy strategies).
11. Advanced topics: Eulerian/Hamiltonian paths, network flow, matching, and more specialized algorithms.

---

# 13. Tips & Intuition (how to think about graph problems)

* Draw small pictures. Visualize nodes and edges and simulate the algorithm manually for 5–8 nodes.
* Convert grids and matrices into graphs (cell → node, neighboring cells → edges) when appropriate.
* Ask: is the graph directed? weighted? dense or sparse? These answers guide which representation and algorithms to use.
* For shortest path: if negative edges → Bellman–Ford; if non-negative → Dijkstra.
* For MST: think "connect everything with minimum cost" — Kruskal sorts edges, Prim grows a tree.
* For reachability and components: DFS/BFS do most of the heavy lifting.


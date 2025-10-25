/*
Question:-
  There is a directed graph of n nodes with each node labeled from 0 to n - 1. The
 graph is represented by a 0-indexed 2D integer array graph where graph[i] is an
 integer array of nodes adjacent to node i, meaning there is an edge from node i to
 each node in graph[i].
A node is a terminal node if there are no outgoing edges. A node is a safe node if
 every possible path starting from that node leads to a terminal node (or another
 safe node).
 Return an array containing all the safe nodes of the graph. The answer should be
 sorted in ascending order.
 Example 1
 Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 Output: [2,4,5,6]
 Explanation: The given graph is shown above.
 Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of
 them.
 Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 Example 2
 Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 Output: [4]
 Explanation:
 Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
*/

import java.util.*;

public class SafeNodesFinder {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        // Step 1: Build reversed graph
        List<List<Integer>> revGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) revGraph.add(new ArrayList<>());

        int[] indeg = new int[n]; // indegree in reversed graph

        // Reverse all edges
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                revGraph.get(v).add(u); // reverse edge
                indeg[u]++;             // indegree of u increases
            }
        }

        // Step 2: Queue for nodes with indegree 0 (terminal nodes)
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        // Step 3: Apply Kahn's algorithm
        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true; // node is safe
            for (int prev : revGraph.get(node)) {
                indeg[prev]--;
                if (indeg[prev] == 0) q.offer(prev);
            }
        }

        // Step 4: Collect safe nodes
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) ans.add(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph1)); // [2, 4, 5, 6]

        int[][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(eventualSafeNodes(graph2)); // [4]
    }
}

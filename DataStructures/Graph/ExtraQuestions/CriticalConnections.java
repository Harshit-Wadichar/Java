import java.util.*;

public class CriticalConnections {
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (List<Integer> conn : connections) {
            int u = conn.get(0), v = conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: Initialize arrays
        int[] disc = new int[n]; // discovery time
        int[] low = new int[n];  // lowest reachable vertex
        Arrays.fill(disc, -1);   // unvisited marker

        List<List<Integer>> bridges = new ArrayList<>();

        // Step 3: DFS from node 0 (or any unvisited node)
        dfs(0, -1, disc, low, graph, bridges);

        return bridges;
    }

    private void dfs(int u, int parent, int[] disc, int[] low,
                     List<List<Integer>> graph, List<List<Integer>> bridges) {
        disc[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (v == parent) continue; // Skip the edge to parent

            if (disc[v] == -1) { // If v is unvisited
                dfs(v, u, disc, low, graph, bridges);
                low[u] = Math.min(low[u], low[v]);

                // Bridge condition
                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Test
    public static void main(String[] args) {
        CriticalConnections cc = new CriticalConnections();
        List<List<Integer>> connections1 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3)
        );
        System.out.println(cc.criticalConnections(4, connections1)); // [[1, 3]]

        List<List<Integer>> connections2 = Arrays.asList(
                Arrays.asList(0, 1)
        );
        System.out.println(cc.criticalConnections(2, connections2)); // [[0, 1]]
    }
}

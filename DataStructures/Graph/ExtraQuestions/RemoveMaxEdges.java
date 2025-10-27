import java.util.*;

public class RemoveMaxEdges {

    // Disjoint Set Union (Union-Find) with path compression and union by rank
    static class DSU {
        int[] parent;
        int[] rank;
        int components; // number of connected components

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            components = n;
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        // return true if a union happened (they were in different sets)
        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            components--;
            return true;
        }
    }

    // Main function to solve the problem
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        // Sort is not required if we manually iterate types in required order.
        // We'll first handle type 3, then type 1, then type 2.
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int usedEdges = 0;

        // 1) Use all type 3 edges first (both can use)
        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean usedForAlice = alice.union(e[1], e[2]);
                boolean usedForBob = bob.union(e[1], e[2]);
                // If at least one union merged different components, the edge is useful.
                if (usedForAlice || usedForBob) usedEdges++;
            }
        }

        // 2) Type 1 edges (Alice only)
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (alice.union(e[1], e[2])) usedEdges++;
            }
        }

        // 3) Type 2 edges (Bob only)
        for (int[] e : edges) {
            if (e[0] == 2) {
                if (bob.union(e[1], e[2])) usedEdges++;
            }
        }

        // Check if both can traverse the full graph (single component)
        if (alice.components != 1 || bob.components != 1) return -1;

        // Maximum removable edges = total edges - used edges
        return edges.length - usedEdges;
    }

    // Simple test main
    public static void main(String[] args) {
        int n1 = 4;
        int[][] edges1 = {
                {3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}
        };
        System.out.println(maxNumEdgesToRemove(n1, edges1)); // expected 2

        int n2 = 4;
        int[][] edges2 = {
                {3,1,2},{3,2,3},{1,1,4},{2,1,4}
        };
        System.out.println(maxNumEdgesToRemove(n2, edges2)); // expected 0
    }
}


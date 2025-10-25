import java.util.*;

public class CheapestFlightsDijkstra {

    static class Edge {
        int to;
        int cost;
        Edge(int to, int cost) { this.to = to; this.cost = cost; }
    }

    // state for priority queue
    static class State {
        int node;
        int cost;
        int stops; // number of edges used to reach this node
        State(int node, int cost, int stops) {
            this.node = node; this.cost = cost; this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // adjacency list
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] f : flights) {
            adj[f[0]].add(new Edge(f[1], f[2]));
        }

        final int INF = Integer.MAX_VALUE / 4;
        // best[node][s] = cheapest cost to reach `node` using exactly `s` edges (0..K+1)
        int maxEdges = K + 1; // max allowed edges
        int[][] best = new int[n][maxEdges + 1];
        for (int i = 0; i < n; i++) Arrays.fill(best[i], INF);
        best[src][0] = 0;

        // min-heap by cost
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new State(src, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            int costSoFar = cur.cost;
            int edgesUsed = cur.stops;

            // If we popped a state that is worse than already-known best, skip it
            if (costSoFar > best[u][edgesUsed]) continue;

            // If we've reached destination, the first time we pop dst is the cheapest cost
            if (u == dst) return costSoFar;

            // If we've already used maximum allowed edges, we cannot go further from here
            if (edgesUsed == maxEdges) continue;

            // Explore neighbours
            for (Edge e : adj[u]) {
                int v = e.to;
                int newCost = costSoFar + e.cost;
                int newEdgesUsed = edgesUsed + 1;

                if (newCost < best[v][newEdgesUsed]) {
                    best[v][newEdgesUsed] = newCost;
                    pq.add(new State(v, newCost, newEdgesUsed));
                }
            }
        }

        return -1; // destination not reachable within K stops
    }

    // quick test
    public static void main(String[] args) {
        CheapestFlightsDijkstra cf = new CheapestFlightsDijkstra();

        int n1 = 4;
        int[][] flights1 = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(cf.findCheapestPrice(n1, flights1, 0, 3, 1)); // expected 700

        int n2 = 3;
        int[][] flights2 = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(cf.findCheapestPrice(n2, flights2, 0, 2, 1)); // expected 200
    }
}

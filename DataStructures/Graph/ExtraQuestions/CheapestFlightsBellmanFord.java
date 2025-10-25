import java.util.Arrays;

public class CheapestFlightsBellmanFord {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final int INF = 1_000_000_000; // large
        int[] prev = new int[n];
        Arrays.fill(prev, INF);
        prev[src] = 0;

        for (int t = 1; t <= K + 1; t++) {
            int[] cur = Arrays.copyOf(prev, n); // start with previous costs (allows <= t-1 edges)
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (prev[u] == INF) continue;
                if (prev[u] + w < cur[v]) {
                    cur[v] = prev[u] + w;
                }
            }
            prev = cur;
        }

        return prev[dst] >= INF ? -1 : prev[dst];
    }

    // Quick test (use in main or unit test):
    public static void main(String[] args) {
        CheapestFlightsBellmanFord cf = new CheapestFlightsBellmanFord();
        int n1 = 4;
        int[][] flights1 = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(cf.findCheapestPrice(n1, flights1, 0, 3, 1)); // 700

        int n2 = 3;
        int[][] flights2 = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(cf.findCheapestPrice(n2, flights2, 0, 2, 1)); // 200
    }
}

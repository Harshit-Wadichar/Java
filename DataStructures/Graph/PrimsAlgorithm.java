import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    static class Pair implements Comparable<Pair> {
        int v;
        int wt;
        int parent;
        public Pair(int v, int wt, int parent) {
            this.v = v;
            this.wt = wt;
            this.parent = parent;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.wt-p2.wt;
        }
    }
    //O(ElogE)
    public static void primAlgo(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        ArrayList<Edge> mst[] = new ArrayList[graph.length];
        for(int i=0; i<graph.length; i++) {
            mst[i] = new ArrayList<>();
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, -1));
        int cost = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(!vis[curr.v]) {
                if(curr.parent != -1) {
                    mst[curr.parent].add(new Edge(curr.parent, curr.v, curr.wt));
                }
                vis[curr.v] = true;
                cost += curr.wt;
                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if(!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt, e.src));

                    }
                }
            }
        }
        System.out.println("The cost of minimum spanning tree is : "+cost);
        for(int i = 0; i< mst.length-1; i++){
            for(int j = 0; j< mst[i].size(); j++ ){
                Edge h = mst[i].get(j);
                System.out.println(h.src + " "+ h.dest + " "+h.wt + " ");
            }
        }

    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primAlgo(graph);
    }
}
 
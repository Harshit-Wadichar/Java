import java.util.*;

public class CourseSchedule {

    // Returns true if you can finish all courses
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();

        // indegree array
        int[] indeg = new int[numCourses];

        // build graph: for each [a, b], add edge b -> a
        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            adj[b].add(a);
            indeg[a]++;
        }

        // queue for nodes with indegree 0
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int visited = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;
            for (int v : adj[u]) {
                indeg[v]--;
                if (indeg[v] == 0) q.offer(v);
            }
        }

        return visited == numCourses;
    }

    // Example tests
    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prereq1 = {{1, 0}}; // can take 0 then 1
        System.out.println("Example1 expected true -> " + canFinish(numCourses1, prereq1));

        int numCourses2 = 2;
        int[][] prereq2 = {{1,0}, {0,1}}; // cycle
        System.out.println("Example2 expected false -> " + canFinish(numCourses2, prereq2));

        // extra test: no prerequisites
        int numCourses3 = 4;
        int[][] prereq3 = {};
        System.out.println("No prereq expected true -> " + canFinish(numCourses3, prereq3));

        int numCourses4 = 3;
        int[][] prereq4 = {{1,0}, {2,1}}; // cycle
        System.out.println("Example4 expected false -> " + canFinish(numCourses4, prereq4));
    }
}

/*
 You are given an m x n grid where each cell can have one of three values:
 ● 0 representing an empty cell,
 ● 1 representing a fresh orange, or
 ● 2 representing a rotten orange.
 Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange
 becomes rotten.
 Return the minimum number of minutes that must elapse until no cell has a fresh
 orange. If this is impossible, return -1.
 Example 1
 Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 Output: 4
 Example 2
 Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 */

import java.util.*;

public class RottenOranges {

    // Returns minimum minutes required to rot all fresh oranges, or -1 if impossible
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>(); // each entry: {r, c, time}
        int freshCount = 0;

        // Initialize: add all rotten oranges to queue and count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges, 0 minutes needed
        if (freshCount == 0) return 0;

        int minutesElapsed = 0;
        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };//directions

        // BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], t = cur[2];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    // Infect the fresh orange
                    grid[nr][nc] = 2;
                    freshCount--;
                    queue.offer(new int[]{nr, nc, t + 1});
                    minutesElapsed = Math.max(minutesElapsed, t + 1);
                }
            }
        }

        // If there are still fresh oranges left, impossible
        return (freshCount == 0) ? minutesElapsed : -1;
    }

    // Example runs for the two examples given
    public static void main(String[] args) {
        int[][] grid1 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int[][] grid2 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };

        System.out.println("Example 1 Output: " + orangesRotting(copy(grid1))); // expected 4
        System.out.println("Example 2 Output: " + orangesRotting(copy(grid2))); // expected -1
    }

    // Helper to copy grid so examples don't mutate the original arrays
    private static int[][] copy(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++) System.arraycopy(grid[i], 0, g[i], 0, n);
        return g;
    }
}

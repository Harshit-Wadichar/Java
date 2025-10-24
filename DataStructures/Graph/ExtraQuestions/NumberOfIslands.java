/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's
 (water), return the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands
 horizontally or vertically. You may assume all four edges of the grid are all
 surrounded by water.
 Example 1
 Input: grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 Output: 1
 Example 2
 Input: grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 Output: 3
 */

public class NumberOfIslands {

    // Main function to count islands
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    dfsMark(grid, r, c, m, n); // mark the whole island
                }
            }
        }
        return islands;
    }

    // DFS that marks visited land cells by setting them to '0'
    private static void dfsMark(char[][] grid, int r, int c, int m, int n) {
        // boundary and water check
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') return;

        grid[r][c] = '0'; // mark visited

        // explore 4-directional neighbors (graph edges)
        dfsMark(grid, r - 1, c, m, n); // up
        dfsMark(grid, r + 1, c, m, n); // down
        dfsMark(grid, r, c - 1, m, n); // left
        dfsMark(grid, r, c + 1, m, n); // right
    }

    // Helper to convert example String[][] to char[][]
    private static char[][] toCharGrid(String[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        char[][] g = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = arr[i][j].charAt(0); // "1" -> '1'
            }
        }
        return g;
    }

    // Test with given examples
    public static void main(String[] args) {
        String[][] ex1 = {
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
        };
        String[][] ex2 = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        System.out.println("Example 1 -> expected 1, got: " + numIslands(toCharGrid(ex1)));
        System.out.println("Example 2 -> expected 3, got: " + numIslands(toCharGrid(ex2)));
    }
}

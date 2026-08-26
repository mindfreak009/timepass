package dsa.graph.rottingoranges;


// Difficulty: Medium
// Topics: Array, BFS, Matrix

// You are given an m x n grid where each cell can have one of three values:
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting
// only happens 4-directionally.

// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

// Constraints:
//     m == grid.length
//     n == grid[i].length
//     1 <= m, n <= 10
//     grid[i][j] is 0, 1, or 2.

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Count fresh oranges and add rotten oranges to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshCount == 0) {
            return 0;
        }

        int time = 0;

        // Process the queue until it's empty
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process each level of rotten oranges
            for (int i = 0; i < size; i++) {
                int[] rottenLoc = queue.poll();
                int r = rottenLoc[0];
                int c = rottenLoc[1];
                int neighbours[][] =  {
                        // up      // right     // down   // left
                        {r-1, c}, {r, c+1},   {r+1, c},   {r, c-1}
                };

                // Check all neighbours
                for (int[] neighbour : neighbours) {
                    int nr = neighbour[0];
                    int nc = neighbour[1];

                    // Check for out of bounds or already rotten/empty
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 2 || grid[nr][nc] == 0) {
                        continue;
                    }

                    // Mark the orange as rotten and add to the queue
                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    freshCount--;

                    // If all fresh oranges are rotten, return the time taken
                    if (freshCount == 0) {
                        return time + 1;
                    }
                }
            }
            time++;
        }

        // If there are still fresh oranges left, return -1
        return -1;
    }
}

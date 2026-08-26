package dsa.arrays.first_completely_painted_row_or_column;

// Difficulty : Medium

// You are given a 0-indexed integer array arr, and an m x n integer matrix mat.arr and mat both contain
// all the integers in the range [1, m * n].

// Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

// Return the smallest index i at which either a row or a column will be completely painted in mat.

// Example 1:
// Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
// Output: 2
// Explanation: The moves are shown in order, and both the first row and second column of
// the matrix become fully painted at arr[2].

// Example 1:
// Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
// Output: 3
// Explanation: The second column becomes fully painted at arr[3].

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn {
    public static void main(String[] args) {
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat = {{3,2,5},{1,4,6},{8,7,9}};

        System.out.println(firstCompleteIndex(arr, mat));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;  // rows
        int m = mat[0].length;  // cols

        int[] rowCount =  new int[n];
        int[] colCount =  new int[m];

        // num -> (r,c)
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {  // rows
            for (int j = 0; j < m; j++) { // cols
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int totalCells = n*m;
        for (int i = 0; i < totalCells; i++) {
            int[] cell = map.get(arr[i]);
            rowCount[cell[0]]++;
            colCount[cell[1]]++;

            // CHECKING :
            // rowCount matching with total no. of cols  OR
            // colCount matching with total no. of rows
            if(rowCount[cell[0]] == m || colCount[cell[1]] == n) {
                return i;
            }
        }
        return -1;
    }
}

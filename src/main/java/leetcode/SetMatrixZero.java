package leetcode;

// Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Explanation: Since matrix[2][2]=0.  Therefore the 2nd column and 2nd row wil be set to 0.

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {

//        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
//        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
//        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
//        matrix.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
//
//        int row = matrix.size();
//        int col = matrix.get(0).size();
//
//        System.out.println("row ::" +row);
//        System.out.println("col ::" +matrix.get(2));

    int[][] matrix1={{1,1,1},{1,0,1},{1,1,1}};

    int[][] newMatrix = new int[matrix1.length][];
        for (int i = 0; i < matrix1.length-1; i++) {
            for (int j = i+1; j < matrix1.length-1 ; j++) {
                if(matrix1[i][j] == 0) {
                    newMatrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(newMatrix));
    }
}

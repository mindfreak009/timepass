package interview_ques.productbased.zyx;

import java.util.ArrayList;
import java.util.List;

// Output is getting printed RIGHT !!!
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        List<Integer> spiralMatrix = findSpiralMatrix(matrix);

        System.out.println("Printing spiral matrix");
        System.out.println("================================");

        int numbersPerRow = 4;

        for (int i = 0; i < spiralMatrix.size(); i++) {
           // System.out.print(spiralMatrix.get(i) + " ");
            System.out.printf("%5d", spiralMatrix.get(i));

            if ((i + 1) % numbersPerRow == 0) {
                System.out.println();  // Move to the next row
            }

        }
    }

    private static List<Integer> findSpiralMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix.length - 1;

        int dir = 0;
        List<Integer> list = new ArrayList<>();

        while(top <= bottom && left <= right) {
            if(dir == 0){
                // first row
                for (int i = left; i <=right ; i++) {
                    // here, row is fixed but column is changing
                    list.add(matrix[top][i]);

                }
                top++;
            } else if(dir ==1){
                // last column
                for (int i = top; i <=bottom ; i++) {
                    // here, row is changing but column is fixed
                    list.add(matrix[i][right]);
                }
                right--;
            } else if(dir == 2) {
                // last row
                for (int i = right; i >= left; i--) {
                    // here, row is fixed but column is changing
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            } else if(dir == 3) {
                // first column
                for (int i = bottom; i >=top ; i--) {
                    // here, row is changing but column is fixed
                    list.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1) % 4;
        }
        System.out.println("list inside");
        return list;
    }
}

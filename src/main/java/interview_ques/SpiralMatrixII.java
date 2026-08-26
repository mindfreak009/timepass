package interview_ques;

// Given an m x n matrix, return all elements of the matrix in spiral order.
// Generate a m x n matrix given the size of the matrix...
public class SpiralMatrixII {

    public static void main(String[] args) {
        int n = 6; // Size of the matrix
        int[][] matrix = new int[n][n];
        fillSpiralMatrix(matrix, n);
        printMatrix(matrix);
    }

    public static void fillSpiralMatrix(int[][] matrix, int n) {
        int value = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (value <= n * n) {
            // Fill the top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;

            // Fill the right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            // Fill the bottom row
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = value++;
            }
            bottom--;

            // Fill the left column
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = value++;
            }
            left++;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value); // Print each number with a width of 4
            }
            System.out.println();
        }
    }
}


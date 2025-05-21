import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        // check first row
        for (int c = 0; c < COLS; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // check first col
        for (int r = 0; r < ROWS; r++) {
            if (matrix[r][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // check rest of grid
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // fill rows with zero
        for (int r = 1; r < ROWS; r++) {
            if (matrix[r][0] == 0) {
                Arrays.fill(matrix[r], 0);
            }
        }

        // fill cols with zero
        for (int c = 1; c < COLS; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 0; r < ROWS; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        // fill first row with zero
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }

        // fill first col with zero
        if (firstColZero) {
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}

// time O(n)
// space O(1)
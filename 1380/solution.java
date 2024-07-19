import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int luckyNumber = -1;
        int i = -1;

        for (int row = 0; row < ROWS; row++) {
            int rowMin = Integer.MAX_VALUE;
            for (int col = 0; col < COLS; col++) {
                rowMin = Math.min(rowMin, matrix[row][col]);
            }
            if (rowMin > luckyNumber) {
                i = row;
                luckyNumber = rowMin;
            }
        }

        for (int col = 0; col < COLS; col++) {
            if (matrix[i][col] == luckyNumber) {
                for (int row = 0; row < ROWS; row++) {
                    if (matrix[row][col] > luckyNumber) {
                        return new ArrayList<>();
                    }
                }
                List<Integer> res = new ArrayList<>();
                res.add(luckyNumber);
                return res;
            }
        }
        return null;
    }
}

// time O(nm)
// space O(1)
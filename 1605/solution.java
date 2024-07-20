class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int ROWS = rowSum.length;
        int COLS = colSum.length;
        int[][] res = new int[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                res[row][col] += Math.min(rowSum[row], colSum[col]);
                rowSum[row] -= res[row][col];
                colSum[col] -= res[row][col];
            }
        }
        return res;

    }
}

// time O(mn)
// space O(1)
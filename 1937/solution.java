class Solution {
    public long maxPoints(int[][] points) {
        int ROWS = points.length;
        int COLS = points[0].length;
        long[] prevRow = new long[COLS];
        for (int i = 0; i < COLS; i++) {
            prevRow[i] = points[0][i];
        }

        for (int i = 1; i < ROWS; i++) {
            long left = 0;
            long[] currRow = new long[COLS];
            for (int j = 0; j < COLS; j++) {
                left = Math.max(left - 1, prevRow[j]);
                currRow[j] = left + points[i][j];
            }
            long right = 0;
            for (int j = COLS - 1; j >= 0; j--) {
                right = Math.max(right - 1, prevRow[j]);
                currRow[j] = Math.max(currRow[j], right + points[i][j]);
            }
            prevRow = currRow;
        }

        long res = 0;
        for (int j = COLS - 1; j >= 0; j--) {
            res = Math.max(res, prevRow[j]);
        }
        return res;
    }
}

// time O(mn)
// space O(n)
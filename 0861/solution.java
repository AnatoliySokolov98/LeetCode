class Solution {
    public int matrixScore(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int res = (1 << (COLS - 1)) * ROWS;
        for (int col = 1; col < COLS; col++) {
            int colTotal = 0;
            for (int row = 0; row < ROWS; row++) {
                colTotal += grid[row][0] == 1 ? grid[row][col] : 1 - grid[row][col];
            }
            res += Math.max(colTotal, ROWS - colTotal) * (1 << (COLS - col - 1));
        }
        return res;
    }
}

// time O(m*n)
// space O(1)
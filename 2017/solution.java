class Solution {
    public long gridGame(int[][] grid) {
        int ROWS = 2, COLS = grid[0].length;
        long[][] prefixes = new long[ROWS][COLS];
        for (int i = 0; i < COLS; i++) {
            prefixes[0][i] = (i == 0 ? 0 : prefixes[0][i - 1]) + grid[0][i];
            prefixes[1][i] = (i == 0 ? 0 : prefixes[1][i - 1]) + grid[1][i];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < COLS; i++) {
            long top = prefixes[0][COLS - 1] - prefixes[0][i];
            long bot = i == 0 ? 0 : prefixes[1][i - 1];
            res = Math.min(res, Math.max(top, bot));
        }
        return res;
    }
}
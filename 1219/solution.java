class Solution {
    int[][] dirs;
    boolean[][] visited;
    int ROWS;
    int COLS;
    int totalGold;

    public int getMaximumGold(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        visited = new boolean[ROWS][COLS];
        int res = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                totalGold += grid[row][col];
            }
        }

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++)
                res = Math.max(res, dfs(row, col, grid));
            if (res == totalGold) {
                return totalGold;
            }
        }
        return res;
    }

    public int dfs(int row, int col, int[][] grid) {
        if (row < 0 || row == ROWS || col < 0 || col == COLS || grid[row][col] == 0 || visited[row][col] == true) {
            return 0;
        }
        int res = grid[row][col];
        visited[row][col] = true;
        for (int[] dir : dirs) {
            res = Math.max(res, grid[row][col] + dfs(row + dir[0], col + dir[1], grid));
            if (res == totalGold) {
                return totalGold;
            }
        }
        visited[row][col] = false;
        return res;
    }
}

// time O(m*n 3^(valid cells))
// space O(m*n)

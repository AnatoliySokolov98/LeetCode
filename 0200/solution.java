class Solution {
    int ROWS;
    int COLS;
    boolean[][] visited;
    int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visited = new boolean[ROWS][COLS];
        int islands = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    islands++;
                    dfs(row, col, grid);
                }
            }
        }
        return islands;
    }

    private void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row == ROWS || col < 0 || col == COLS || grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], grid);
        }
    }
}

// time O(n*m)
// space O(n*m)
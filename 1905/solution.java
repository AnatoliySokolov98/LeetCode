class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int ROWS;
    int COLS;
    int visited[][];

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        ROWS = grid1.length;
        COLS = grid1[0].length;
        visited = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                visited[r][c] = grid2[r][c];
            }
        }
        int subIslands = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (visited[r][c] == 1 && dfs(r, c, grid1)) {
                    subIslands++;
                }
            }
        }
        return subIslands;
    }

    private boolean dfs(int r, int c, int[][] grid1) {
        if (r < 0 || r == ROWS || c < 0 || c == COLS || visited[r][c] == 0) {
            return true;
        }
        visited[r][c] = 0;
        boolean check = grid1[r][c] == 1;
        for (int[] dir : dirs) {
            if (!dfs(r + dir[0], c + dir[1], grid1)) {
                check = false;
            }
        }
        return check;
    }
}

// time O(nm)
// space O(nm)
class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int res = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] != 1) {
                    continue;
                }
                for (int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if (x < 0 || x == ROWS || y < 0 || y == COLS || grid[x][y] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}

// time O(rows * cols)
// space O(1)
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int res = 0;

        for (int r = 0; r < ROWS - 2; r++) {
            for (int c = 0; c < COLS - 2; c++) {
                if (isValidSquare(grid, r, c)) {
                    res += 1;
                }
            }
        }
        return res;
    }

    private boolean isValidSquare(int[][] grid, int x, int y) {
        if (grid[x + 1][y + 1] != 5) {
            return false;
        }

        int s = 15;
        boolean[] seen = new boolean[10];

        for (int r = 0; r < 3; r++) {
            int rowSum = 0;
            for (int c = 0; c < 3; c++) {
                int val = grid[x + r][y + c];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }
                seen[val] = true;
                rowSum += val;
            }
            if (rowSum != s) {
                return false;
            }
        }

        for (int c = 0; c < 3; c++) {
            int colSum = 0;
            for (int r = 0; r < 3; r++) {
                colSum += grid[x + r][y + c];
            }
            if (colSum != s) {
                return false;
            }
        }

        int diag1 = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        int diag2 = grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];

        return diag1 == s && diag2 == s;
    }
}

// time O(nm)
// space O(1)
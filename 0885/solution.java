class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total = rows * cols;
        int[][] res = new int[total][2];
        int i = 1;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int d = 0;
        int moves = 0;
        int x = rStart;
        int y = cStart;
        res[0] = new int[] { rStart, cStart };
        while (i < res.length) {
            int steps = (moves / 2) + 1;
            for (int j = 0; j < steps; j++) {
                x += dirs[d][0];
                y += dirs[d][1];
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    res[i++] = new int[] { x, y };
                }
            }
            moves++;
            d = (d + 1) % 4;
        }
        return res;
    }
}

// time O(max(row, col) ^ 2)
// space O(1)

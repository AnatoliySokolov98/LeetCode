class Solution {
    public int[][] largestLocal(int[][] grid) {
        int N = grid.length;
        int[][] res = new int[N - 2][N - 2];
        for (int row = 0; row < N - 2; row++) {
            for (int col = 0; col < N - 2; col++) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        res[row][col] = Math.max(res[row][col], grid[row + 1 + i][col + 1 + j]);
                    }
                }
            }
        }
        return res;
    }
}

// time O(n^2)
// space O(1)
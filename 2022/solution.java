class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][] {};
        }
        int[][] res = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res[r][c] = original[r * n + c];
            }
        }
        return res;
    }
}

// time O(mn)
// space O(1)

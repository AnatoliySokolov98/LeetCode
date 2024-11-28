class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] matrix = new int[m][n];
        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = 2;
        }
        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = 3;
        }
        for (int r = 0; r < m; r++) {
            int state = 0;
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 2) {
                    state = 1;
                } else if (matrix[r][c] == 3) {
                    state = 0;
                } else {
                    matrix[r][c] = state | matrix[r][c];
                }
            }
            state = 0;
            for (int c = n - 1; c >= 0; c--) {
                if (matrix[r][c] == 2) {
                    state = 1;
                } else if (matrix[r][c] == 3) {
                    state = 0;
                } else {
                    matrix[r][c] = state | matrix[r][c];
                }
            }
        }
        for (int c = 0; c < n; c++) {
            int state = 0;
            for (int r = 0; r < m; r++) {
                if (matrix[r][c] == 2) {
                    state = 1;
                } else if (matrix[r][c] == 3) {
                    state = 0;
                } else {
                    matrix[r][c] = state | matrix[r][c];
                }
            }
            state = 0;
            for (int r = m - 1; r >= 0; r--) {
                if (matrix[r][c] == 2) {
                    state = 1;
                } else if (matrix[r][c] == 3) {
                    state = 0;
                } else {
                    matrix[r][c] = state | matrix[r][c];
                }
            }
        }
        int res = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}

// time O(nm)
// space O(nm)
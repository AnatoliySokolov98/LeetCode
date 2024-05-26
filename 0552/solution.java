class Solution {
    public int checkRecord(int n) {
        int MOD = 1_000_000_007;
        // max absences
        int rows = 2;
        // max late days
        int cols = 3;
        int[][] dp = new int[rows][cols];
        // first day present
        dp[0][0] = 1;
        // first day absent
        dp[1][0] = 1;
        // first day late
        dp[0][1] = 1;

        for (int i = 2; i <= n; i++) {
            int[][] newDp = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int val = dp[row][col];
                    newDp[row][0] = (newDp[row][0] + val) % MOD;
                    if (row == 0) {
                        newDp[row + 1][0] = (newDp[row + 1][0] + val) % MOD;
                    }
                    if (col < 2) {
                        newDp[row][col + 1] = (newDp[row][col + 1] + val) % MOD;
                    }
                }
            }
            dp = newDp;
        }
        int total = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                total = (total + dp[row][col]) % MOD;
            }
        }
        return total;
    }
}

// time O(n)
// spaace O(1)
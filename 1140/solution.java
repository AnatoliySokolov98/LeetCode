import java.util.Arrays;

class Solution {
    private int[][][] dp;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n + 1][2];
        for (int[][] row : dp) {
            for (int[] innerRow : row) {
                Arrays.fill(innerRow, -1);
            }
        }
        return helper(piles, 0, 1, 1);
    }

    private int helper(int[] piles, int index, int M, int turn) {
        // out of bounds
        if (index == piles.length) {
            return 0;
        }

        // cache
        if (dp[index][M][turn] != -1) {
            return dp[index][M][turn];
        }

        int res;
        // alices turn
        if (turn == 1) {
            res = 0;
            // bobs turn
        } else {
            res = Integer.MAX_VALUE;
        }

        int stones = 0;
        for (int X = 0; X < 2 * M; X++) {
            if (index + X >= piles.length) {
                break;
            }
            stones += piles[index + X];
            // alices turn
            if (turn == 1) {
                res = Math.max(res, stones + helper(piles, index + X + 1, Math.max(M, X + 1), 0));
            } else {
                res = Math.min(res, helper(piles, index + X + 1, Math.max(M, X + 1), 1));
            }
        }

        dp[index][M][turn] = res;
        return res;
    }
}

// time O(n^3)
// space O(n^2)
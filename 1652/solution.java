class Solution {
    public int strangePrinter(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                sb.append(chars[i]);
            }
        }
        s = sb.toString();

        int n = s.length();
        int[][] memo = new int[n][n];

        return dp(s, 0, n - 1, memo);
    }

    private int dp(String s, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int res = 1 + dp(s, i + 1, j, memo);

        for (int k = i + 1; k <= j; k++) {
            if (s.charAt(i) == s.charAt(k)) {
                res = Math.min(res, dp(s, i + 1, k, memo) + dp(s, k + 1, j, memo));
            }
        }

        memo[i][j] = res;
        return res;
    }
}

// time O(n^3)
// space O(n^2)
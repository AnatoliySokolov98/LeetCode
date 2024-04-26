import java.util.Arrays;

class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int currValue = (int) (s.charAt(i) - 'a');
            int currTotal = 1;
            int bot = Math.max(0, currValue - k);
            int top = Math.min(26, currValue + k + 1);
            for (int j = bot; j < top; j++) {
                if (Math.abs(j - currValue) <= k) {
                    currTotal = Math.max(currTotal, dp[j] + 1);
                }
            }
            dp[currValue] = currTotal;
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}

// Time O(n*26)
// Space O(26)
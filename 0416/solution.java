class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num: nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
            if(dp[target]) {
                return true;
            }
        }
        return false;
    }
}

// time O(n * target)
// space O(target)


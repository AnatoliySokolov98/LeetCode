class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int res = Integer.MAX_VALUE;
        int curr = 0;
        for (int r = 0; r < nums.length; r++) {
            curr += nums[r];
            while (curr - nums[l] >= target && l <= r) {
                curr -= nums[l++];
            }

            if (curr >= target) {
                res = Math.min(res, r - l + 1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
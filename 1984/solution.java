import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = k - 1;
        int res = Integer.MAX_VALUE;
        while (r < nums.length) {
            res = Math.min(res, nums[r] - nums[l]);
            r++;
            l++;
        }
        return res;
    }
}
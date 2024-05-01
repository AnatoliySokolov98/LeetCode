import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int l = 0;
        long curr = 0;
        for (int r = 1; r < nums.length; r++) {
            curr += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (curr > k) {
                curr -= nums[r] - nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
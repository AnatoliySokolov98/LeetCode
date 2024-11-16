import java.util.Arrays;

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Arrays.fill(res, -1);
        int streak = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] == nums[i - 1] + 1) {
                streak++;
            } else {
                streak = 1;
            }
            if (streak >= k) {
                res[i - k + 1] = nums[i];
            }
        }
        return res;
    }
}

// time O(n)
// space O(1)

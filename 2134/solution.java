class Solution {
    public int minSwaps(int[] nums) {
        int N = nums.length;
        int W = 0;
        for (int num : nums) {
            if (num == 1) {
                W++;
            }
        }

        if (W == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int zeroes = 0;
        for (int r = 0; r < nums.length + W - 1; r++) {
            if (nums[r % N] == 0) {
                zeroes++;
            }
            if (r >= W && nums[r - W] == 0) {
                zeroes--;
            }
            if (r >= W - 1) {
                res = Math.min(res, zeroes);
            }
        }
        return res;
    }
}

// time O(n)
// space O(1)
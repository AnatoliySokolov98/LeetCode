class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        int res = r;
        while (l <= r) {
            int p = l + (r - l) / 2;
            if (canRob(nums, k, p)) {
                res = p;
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        return res;
    }

    private boolean canRob(int[] nums, int k, int target) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= target) {
                i++;
                count++;
            }
            i++;
        }
        return count >= k;
    }
}

// time O(n * log(max(n)))
// space O(1)
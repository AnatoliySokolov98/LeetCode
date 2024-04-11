class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int p = l + (r - l) / 2;
            if (nums[p] == target) {
                return p;
            }
            if (nums[p] > target) {
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        return -1;
    }
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = r + 1;
        while (l <= r) {
            int p = l + (int) Math.floor((r - l) / 2);
            if (target <= nums[p]) {
                res = p;
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        return res;
    }
}
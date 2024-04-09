class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int right = 0;
        for(int num: nums) {
            right += num;
        }
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right) return i;
            left += nums[i];
        }
        return -1;
    }
}
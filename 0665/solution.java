class Solution {
    public boolean checkPossibility(int[] nums) {
        int top = nums.length - 1;
        while (top > 0 && nums[top - 1] <= nums[top]) {
            top--;
        }

        int bot = 0;
        while (bot < nums.length - 1 && nums[bot + 1] >= nums[bot]) {
            bot++;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? Integer.MIN_VALUE : nums[i - 1];
            int right = i == nums.length - 1 ? Integer.MAX_VALUE : nums[i + 1];
            if (top <= i + 1 && bot >= i - 1 && right >= left)
                return true;
        }
        return false;
    }
}
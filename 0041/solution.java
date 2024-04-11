class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        int C = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > N) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int loc = (nums[i] % C) - 1;
            if (loc >= 0) {
                nums[loc] = (nums[loc] % C) + C;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < C) {
                return i + 1;
            }
        }
        return N + 1;
    }
}
// time O(n)
// space O(1)
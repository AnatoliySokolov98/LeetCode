class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc = inc && true;
                dec = false;
            } else if (nums[i] < nums[i - 1]) {
                dec = dec && true;
                inc = false;
            }
        }
        return inc || dec;
    }
}
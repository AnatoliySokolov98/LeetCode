class Solution {
    public void moveZeroes(int[] nums) {
        int writeTo = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[writeTo++] = num;
            }
        }
        while (writeTo < nums.length) {
            nums[writeTo++] = 0;
        }
    }
}
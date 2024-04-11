class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] == nums[k - 1]) {
                continue;
            }
            nums[k++] = nums[i];
        }
        return k;
    }
}
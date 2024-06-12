class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (i < l) {
                i++;
                continue;
            }
            int curr = nums[i];
            if (curr == 0) {
                nums[i] = nums[l];
                nums[l++] = 0;
            } else if (curr == 2) {
                nums[i] = nums[r];
                nums[r--] = 2;
            } else {
                i++;
            }
        }
    }
}

// time O(n)
// space O(1)
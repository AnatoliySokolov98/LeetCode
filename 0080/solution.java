class Solution {
    public int removeDuplicates(int[] nums) {
        int write_to = 0;
        int count = 0;
        int prev = (int) Math.pow(10, 5);
        for (int num : nums) {
            if (num != prev) {
                count = 1;
            } else {
                count++;
            }
            if (count <= 2) {
                nums[write_to++] = num;
            }
            prev = num;
        }
        return write_to;
    }
}
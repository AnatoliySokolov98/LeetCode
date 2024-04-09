class Solution {
    public int removeElement(int[] nums, int val) {
        int write_to = 0;
        for(int num: nums) {
            if(num != val) {
                nums[write_to++] = num;
            }
        }
        return write_to;
    }
}
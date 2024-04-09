class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int curr = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num == curr) {
                count++;
            }
            else {
                if (count == 0) {
                    count = 1;
                    curr = num;
                }
                else {
                    count--;
                }
            }
        }
        return curr;
    }
}
class Solution {
    public int[] getMaximumXor(int[] nums, int k) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int biggestNum = (int) Math.pow(2, k) - 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = xor ^ biggestNum;
            xor ^= nums[nums.length - i - 1];
        }
        return res;
    }
}

// time O(n)
// space O(1)
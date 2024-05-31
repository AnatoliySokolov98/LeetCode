class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int bit = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & xor) != 0) {
                bit = 1 << i;
                break;
            }
        }
        int first = 0;
        for (int num : nums) {
            if ((num & bit) != 0) {
                first ^= num;
            }
        }
        int second = xor ^ first;
        return new int[] { first, second };
    }
}

// time O(n)
// space O(1)
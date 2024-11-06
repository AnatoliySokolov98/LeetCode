class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        xor ^= k;
        int res = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                res++;
            }
            xor >>= 1;
        }
        return res;
    }
}

// time O(n)
// space O(1)

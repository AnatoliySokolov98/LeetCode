class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int res = 0;
        while (xor > 0) {
            res += xor & 1;
            xor >>= 1;
        }
        return res;
    }
}

// time O(1)
// space O(1)
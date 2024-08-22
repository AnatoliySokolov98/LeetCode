class Solution {
    public int findComplement(int num) {
        int ones = 0;
        int copy = num;
        while (num > 0) {
            ones <<= 1;
            ones += 1;
            num >>= 1;
        }
        return ones - copy;
    }
}

// time O(1)
// space O(1)
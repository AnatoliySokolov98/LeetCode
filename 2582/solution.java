class Solution {
    public int passThePillow(int n, int time) {
        int cycles = time / (n - 1);
        int remainder = time % (n - 1);
        return cycles % 2 == 0 ? 1 + remainder : n - remainder;
    }
}

// time O(1)
// space O(1)
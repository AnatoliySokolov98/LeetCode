class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int twos = 0;
        int threes = 0;
        int fives = 0;

        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(uglyNums[twos] * 2, Math.min(uglyNums[threes] * 3, uglyNums[fives] * 5));
            if (uglyNums[i] == uglyNums[twos] * 2) {
                twos++;
            }
            if (uglyNums[i] == uglyNums[threes] * 3) {
                threes++;
            }
            if (uglyNums[i] == uglyNums[fives] * 5) {
                fives++;
            }
        }
        return uglyNums[n - 1];
    }
}

// time O(n)
// space O(n)
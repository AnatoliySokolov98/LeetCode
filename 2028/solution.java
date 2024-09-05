class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int knownRollTotal = 0;
        for (int roll : rolls) {
            knownRollTotal += roll;
        }
        int meanRollTotal = mean * (n + rolls.length);
        int nRollTotal = meanRollTotal - knownRollTotal;
        if (nRollTotal < n || nRollTotal > 6 * n) {
            return new int[] {};
        }
        int val = nRollTotal / n;
        int extra = nRollTotal % n;
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = val + (i < extra ? 1 : 0);
        }
        return res;
    }
}

// time O(rolls + n)
// space O(1)
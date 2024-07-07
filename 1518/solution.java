class Solution {
    public int numWaterBottles(int fullBottles, int emptyToFullRatio) {
        int emptyBottles = 0;
        int res = 0;
        while (fullBottles > 0) {
            res += fullBottles;
            emptyBottles += fullBottles;
            fullBottles = emptyBottles / emptyToFullRatio;
            emptyBottles = emptyBottles % emptyToFullRatio;
        }
        return res;
    }
}

// time O(log(fullBottles))
// space O(1)
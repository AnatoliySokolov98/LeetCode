import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        int H = h.length;
        long res = 0;
        Arrays.sort(h);
        for (int i = H - 1; i > H - 1 - k; i--) {
            int currHappiness = h[i] - (H - 1 - i);
            if (currHappiness <= 0) {
                return res;
            }
            res += currHappiness;
        }
        return res;
    }
}

// time O(nlogn)
// space O(1)
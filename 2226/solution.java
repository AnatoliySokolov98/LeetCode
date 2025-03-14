class Solution {
    public int maximumCandies(int[] candies, long k) {
        int res = 0;
        int l = 1;
        long total = 0;
        for (int candy : candies) {
            total += candy;
        }
        int r = (int) (total / k);
        while (l <= r) {
            int p = l + (r - l) / 2;
            if (canSplit(p, candies, k)) {
                res = p;
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return res;
    }

    private boolean canSplit(int p, int[] candies, long k) {
        long piles = 0;
        for (int candy : candies) {
            piles += candy / p;
        }
        return piles >= k;
    }
}

// time O(nlog(total / k))
// space O(1)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int flower : bloomDay) {
            l = Math.min(l, flower);
            r = Math.max(r, flower);
        }
        int res = r;
        while (l <= r) {
            int p = l + (r - l) / 2;
            if (canMakeBouquets(bloomDay, m, k, p)) {
                res = p;
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        return res;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int res = 0;
        int curr = 0;
        for (int flower : bloomDay) {
            if (flower <= day) {
                curr++;
                if (curr == k) {
                    res++;
                    curr = 0;
                    if (res == m) {
                        return true;
                    }
                }
            } else {
                curr = 0;
            }
        }
        return false;
    }
}

// time O(nlog(m))
// space O(1)
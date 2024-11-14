class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = 0;
        for (int q : quantities) {
            r = Math.max(r, q);
        }
        int res = r;
        while (l <= r) {
            int p = l + (r - l) / 2;
            if (canSplit(p, n, quantities)) {
                res = p;
                r = res - 1;
            } else {
                l = p + 1;
            }
        }
        return res;

    }

    private boolean canSplit(int maxCapacity, int n, int[] quantities) {
        int res = 0;
        for (int q : quantities) {
            res += q / maxCapacity + (q % maxCapacity == 0 ? 0 : 1);
        }
        return res <= n;
    }
}

// time O(log(max(n))*n)
// space O(1)
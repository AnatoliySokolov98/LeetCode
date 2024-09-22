class Solution {
    public int findKthNumber(int n, int k) {
        k--;
        long curr = 1;
        while (k > 0) {
            long count = countNodes(curr, n);
            if (k >= count) {
                curr++;
                k -= count;
            } else {
                curr *= 10;
                k--;
            }
        }
        return (int) curr;
    }

    private long countNodes(long curr, int n) {
        long nextNode = curr + 1;
        long result = 0;
        while (curr <= n) {
            result += Math.min(n - curr + 1, nextNode - curr);
            curr *= 10;
            nextNode *= 10;
        }
        return result;
    }
}

// time O(log^2(n))
// space O(1)
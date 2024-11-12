class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int k_time = tickets[k];
        int res = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (i < k) {
                res += Math.min(tickets[i], k_time);
            }
            if (i > k) {
                res += Math.min(tickets[i], k_time - 1);
            }
        }
        return res;
    }
}

// time O(n)
// space O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int curr = Integer.MAX_VALUE;
        for (int price : prices) {
            res = Math.max(res, price - curr);
            curr = Math.min(curr, price);
        }
        return res;
    }
}
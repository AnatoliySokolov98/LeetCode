class Solution {
    public int arrangeCoins(int n) {
        int left = 0, right = (int) (Math.sqrt(1 + 8.0 * n) - 1) / 2;
        int maxRows = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long coins = (long) mid * (mid + 1) / 2;
            if (n >= coins) {
                maxRows = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxRows;
    }
}

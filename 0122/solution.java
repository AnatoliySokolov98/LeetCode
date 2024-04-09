import java.util.Map;
import java.util.HashMap;

class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dp(0, prices, 0);
    }

    public int dp(int i, int[] prices, int holding) {
        if (i == prices.length) return 0;

        int key = i * 2 + holding; 
        if (cache.containsKey(key)) return cache.get(key);

        int doNothing = dp(i + 1, prices, holding);
        int doTransaction = (holding == 0 ? -prices[i] : prices[i]) + dp(i + 1, prices, 1 - holding);

        int maxProfit = Math.max(doNothing, doTransaction);
        cache.put(key, maxProfit);

        return maxProfit;
    }
}
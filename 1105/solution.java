import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        Map<Integer, Integer> cache = new HashMap<>();
        return dp(0, books, shelfWidth, cache);
    }

    private int dp(int i, int[][] books, int shelfWidth, Map<Integer, Integer> cache) {
        if (i == books.length) {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        int res = Integer.MAX_VALUE;
        int width = 0;
        int height = 0;
        for (int j = i; j < books.length; j++) {
            width += books[j][0];
            if (width > shelfWidth) {
                break;
            }
            height = Math.max(height, books[j][1]);
            res = Math.min(res, height + dp(j + 1, books, shelfWidth, cache));
        }
        cache.put(i, res);
        return res;
    }
}

// time O(n^2)
// space O(n)
import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        int res = 0;
        int extra = 0;
        System.out.println(counts);
        for (String key : counts.keySet()) {
            if (key.charAt(0) < key.charAt(1)) {
                int val1 = counts.get(key);
                int val2 = counts.getOrDefault(new StringBuilder(key).reverse().toString(), 0);
                res += Math.min(val1, val2) * 4;
            }
            if (key.charAt(0) == key.charAt(1)) {
                res += (counts.get(key) / 2) * 4;
                extra += counts.get(key) % 2;
            }
        }
        return res + (extra > 0 ? 2 : 0);
    }
}

// time O(n)
// time O(n)
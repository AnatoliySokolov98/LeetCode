import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] counts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'a']++;
        }
        Arrays.sort(counts);
        int res = 0;
        for (int i = 25; i >= 0; i--) {
            res += Math.ceil((25 - i + 1) / 8.0) * counts[i];
        }
        return res;
    }
}

// time O(n)
// space O(1)
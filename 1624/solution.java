import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] locs = new int[26];
        Arrays.fill(locs, -1);
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (locs[c] != -1) {
                res = Math.max(i - locs[c] - 1, res);
            } else {
                locs[c] = i;
            }
        }
        return res;
    }
}
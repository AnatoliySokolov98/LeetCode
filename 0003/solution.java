import java.util.Set;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> uniques = new HashSet<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (uniques.contains(s.charAt(r))) {
                uniques.remove(s.charAt(l++));
            }
            uniques.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
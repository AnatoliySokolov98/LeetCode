import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(left.containsKey(s.charAt(i))) {
                right.put(s.charAt(i), i);
            }
            else {
                left.put(s.charAt(i), i);
            }
        }

        for(char key: right.keySet()) {
            Set<Character> chars = new HashSet<>();
            for(int i = left.get(key) + 1; i < right.get(key); i++) {
                chars.add(s.charAt(i));
            }
            res += chars.size();
        }
        return res;
    }
}
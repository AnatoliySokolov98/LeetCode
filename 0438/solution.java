import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (pCount[i] == sCount[i]) {
                matches++;
            }
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (matches == 26) {
                result.add(i);
            }
            if (i < s.length() - p.length()) {
                int right = s.charAt(i + p.length()) - 'a', left = s.charAt(i) - 'a';
                if (pCount[right] == sCount[right]) {
                    matches--;
                }
                sCount[right]++;
                if (pCount[right] == sCount[right]) {
                    matches++;
                }
                if (pCount[left] == sCount[left]) {
                    matches--;
                }
                sCount[left]--;
                if (pCount[left] == sCount[left]) {
                    matches++;
                }
            }
        }
        return result;
    }
}

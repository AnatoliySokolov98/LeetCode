import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] prev = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            int charNum = (int) (words[0].charAt(i) - 'a');
            prev[charNum]++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] curr = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                int charNum = (int) (words[i].charAt(j) - 'a');
                curr[charNum]++;
            }
            for (int j = 0; j < 26; j++) {
                curr[j] = Math.min(curr[j], prev[j]);
            }
            prev = curr;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int charCount = prev[i];
            String c = Character.toString((char) (i + 'a'));
            for (int j = 0; j < charCount; j++) {
                res.add(c);
            }
        }
        return res;
    }
}

// time O(n*w)
// space O(1)
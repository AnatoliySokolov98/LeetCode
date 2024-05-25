import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<String> res;
    StringBuilder curr;
    Set<String> words;

    public List<String> wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>(wordDict);
        res = new ArrayList<>();
        curr = new StringBuilder();
        backtrack(0, s);
        return res;
    }

    private void backtrack(int i, String s) {
        if (i == s.length()) {
            res.add(curr.toString());
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String word = s.substring(i, j + 1);
            if (words.contains(word)) {
                int builderLength = curr.length();
                if (!curr.isEmpty()) {
                    curr.append(' ');
                }
                curr.append(word);
                backtrack(j + 1, s);
                curr.delete(builderLength, curr.length());
            }
        }
    }
}

// time O(2^n + chars)
// space O(chars + n)
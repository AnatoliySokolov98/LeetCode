import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> cache;
    private Trie root;

    public int minExtraChar(String s, String[] dictionary) {
        root = new Trie();
        cache = new HashMap<>();
        for (String word : dictionary) {
            root.insert(word);
        }
        return dp(0, s);
    }

    public int dp(int idx, String s) {
        if (cache.containsKey(idx))
            return cache.get(idx);
        if (idx == s.length()) {
            return 0;
        }

        int res = 1 + dp(idx + 1, s);
        Trie curr = root;
        for (int i = idx; i < s.length(); i++) {
            if (!curr.children.containsKey(s.charAt(i)))
                break;
            curr = curr.children.get(s.charAt(i));
            if (curr.word) {
                res = Math.min(res, dp(i + 1, s));
            }
        }
        cache.put(idx, res);
        return res;
    }
}

class Trie {
    boolean word;
    Map<Character, Trie> children;

    public Trie() {
        word = false;
        children = new HashMap<>();
    }

    public void insert(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!root.children.containsKey(curr)) {
                root.children.put(curr, new Trie());
            }
            root = root.children.get(curr);
        }
        root.word = true;
    }
}

// time O(words * biggestWord + n*n)
// space O(words * biggestWord + n)
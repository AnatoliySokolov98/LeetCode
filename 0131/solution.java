import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> res;
    List<String> subset;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        subset = new ArrayList<>();
        backtrack(0, s);
        return res;
    }

    private boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    private void backtrack(int i, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                subset.add(s.substring(i, j + 1));
                backtrack(j + 1, s);
                subset.removeLast();
            }
        }
    }
}

// time O(2^n * n)
// space O(n)
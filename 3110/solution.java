class Solution {
    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res += (int) Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return res;
    }
}

// time O(n)
// space O(1)
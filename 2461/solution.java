class Solution {
    public int appendCharacters(String s, String t) {
        int tIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(tIndex)) {
                tIndex++;
                if (tIndex == t.length()) {
                    return 0;
                }
            }
        }
        return t.length() - tIndex;
    }
}

// time O(s)
// space O(1)
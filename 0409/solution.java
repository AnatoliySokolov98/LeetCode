class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[60];
        for (int i = 0; i < s.length(); i++) {
            int loc = (int) (s.charAt(i) - 'A');
            counts[loc]++;
        }
        int pairs = 0;
        boolean extra = false;
        for (int count : counts) {
            pairs += count / 2;
            extra = extra || count % 2 == 1;
        }
        return pairs * 2 + (extra ? 1 : 0);
    }
}

// time O(s)
// space O(1)
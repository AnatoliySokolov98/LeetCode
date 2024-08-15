class Solution {
    public int minOperations(String s) {
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == s.charAt(i) - '0') {
                res1++;
            } else {
                res2++;
            }
        }
        return Math.min(res1, res2);
    }
}
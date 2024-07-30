class Solution {
    public int minimumDeletions(String s) {
        int leftB = 0;
        int rightA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                leftB++;
            }
        }
        int res = Math.min(leftB, s.length() - leftB);
        for (int i = s.length() - 1; i >= 0; i--) {
            leftB -= s.charAt(i) == 'b' ? 1 : 0;
            res = Math.min(res, leftB + rightA);
            rightA += s.charAt(i) == 'a' ? 1 : 0;
        }
        return res;
    }
}

// time O(n)
// space O(1)
class Solution {
    public long minimumSteps(String s) {
        long res = 0;
        int r = s.length() - 1;
        for (int l = s.length() - 1; l >= 0; l--) {
            if (s.charAt(l) == '1') {
                res += r - l;
                r--;
            }
        }
        return res;
    }
}

// time O(n)
// space O(1)
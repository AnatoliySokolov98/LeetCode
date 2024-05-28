class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int currCost = 0;
        int l = 0;
        for (int r = 0; r < t.length(); r++) {
            currCost += Math.abs((int) (t.charAt(r) - s.charAt(r)));
            // while window invalid
            while (currCost > maxCost) {
                currCost -= Math.abs((int) (t.charAt(l) - s.charAt(l++)));
            }
            // store result
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

// time O(n)
// space O(1)
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int streak = 0;
        for (int i = 0; i < colors.length + k - 1; i++) {
            int j = i % colors.length;
            int prev = j == 0 ? colors.length - 1 : j - 1;
            if (colors[prev] != colors[j]) {
                streak++;
            } else {
                streak = 1;
            }
            if (streak >= k) {
                res++;
            }
        }
        return res;
    }
}

// time O(n)
// space O(1)
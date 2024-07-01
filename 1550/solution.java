class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int streak = 0;
        for (int a : arr) {
            if (a % 2 == 1) {
                streak++;
                if (streak == 3) {
                    return true;
                }
            } else {
                streak = 0;
            }
        }
        return false;
    }
}

// time O(n)
// space O(1)
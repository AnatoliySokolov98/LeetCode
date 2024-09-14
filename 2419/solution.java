class Solution {
    public int longestSubarray(int[] nums) {
        int biggest = -1;
        int res = 0;
        int streak = 0;
        for (int num : nums) {
            if (num > biggest) {
                biggest = num;
                res = 0;
                streak = 1;
            } else if (num == biggest) {
                streak++;
            } else {
                streak = 0;
            }
            res = Math.max(res, streak);
        }
        return res;
    }
}

// time O(n)
// space O(1)
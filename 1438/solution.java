import java.util.ArrayDeque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<int[]> decreasing = new ArrayDeque<>();
        ArrayDeque<int[]> increasing = new ArrayDeque<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!decreasing.isEmpty() && nums[r] > decreasing.getLast()[1]) {
                decreasing.pollLast();
            }
            decreasing.addLast(new int[] { r, nums[r] });
            while (!increasing.isEmpty() && nums[r] < increasing.getLast()[1]) {
                increasing.pollLast();
            }
            increasing.addLast(new int[] { r, nums[r] });

            while (decreasing.getFirst()[1] - increasing.getFirst()[1] > limit) {
                l++;
                while (decreasing.getFirst()[0] < l) {
                    decreasing.pollFirst();
                }
                while (increasing.getFirst()[0] < l) {
                    increasing.pollFirst();
                }
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}

// time O(n)
// space O(n)
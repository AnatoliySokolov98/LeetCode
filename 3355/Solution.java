public class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int N = nums.length;
        int[] diff = new int[N + 1];
        for (var q : queries) {
            diff[q[0]]--;
            diff[q[1] + 1]++;
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += diff[i];
            if (nums[i] + total > 0) {
                return false;
            }
        }
        return true;
    }
}

// time O(q + n)
// space O(n)

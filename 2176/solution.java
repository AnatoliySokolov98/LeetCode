class Solution {
    public int countPairs(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}

// time O(n^2)
// space O(1)
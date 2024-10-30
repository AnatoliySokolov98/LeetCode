class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];

        Arrays.fill(lefts, 1);
        Arrays.fill(rights, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lefts[i] = Math.max(1 + lefts[j], lefts[i]);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    rights[i] = Math.max(1 + rights[j], rights[i]);
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (lefts[i] > 1 && rights[i] > 1) {
                res = Math.min(res, n - (lefts[i] + rights[i] - 1));
            }
        }

        return res;
    }
}

// time O(n^2)
// space O(n)
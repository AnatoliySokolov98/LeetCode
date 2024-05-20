class Solution {
    int res = 0;
    int subset = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(0, nums);
        return res;
    }

    private void backtrack(int i, int[] nums) {
        if (i == nums.length) {
            res += subset;
            return;
        }
        subset ^= nums[i];
        backtrack(i + 1, nums);
        subset ^= nums[i];
        backtrack(i + 1, nums);
    }
}

// time O(2^n)
// space O(n)
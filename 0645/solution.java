class Solution {
    public int[] findErrorNums(int[] nums) {
        for (int num : nums) {
            nums[(num - 1) % 10_000] += 10_000;
        }

        int[] res = new int[] { 0, 0 };

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 10_000) {
                res[1] = i + 1;
            }

            if (nums[i] > 20_000) {
                res[0] = i + 1;
            }
        }
        return res;
    }
}
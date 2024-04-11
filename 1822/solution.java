class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num < 0) {
                res *= -1;
            } else if (num == 0) {
                return 0;
            }
        }
        return res;
    }
}
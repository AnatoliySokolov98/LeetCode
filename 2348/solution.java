class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == 0) {
                curr++;
            } else {
                curr = 0;
            }
            res += curr;
        }
        return res;
    }
}
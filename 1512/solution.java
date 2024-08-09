class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101];
        int res = 0;
        for (int num : nums) {
            res += counts[num];
            counts[num]++;
        }
        return res;
    }
}
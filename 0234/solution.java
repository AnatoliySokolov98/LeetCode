class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];
        int curr = 1;
        for(int i = 0; i < nums.length; i++) {
            lefts[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            rights[i] = curr;
            curr *= nums[i];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = lefts[i] * rights[i];
        }
        return res;
    }
}
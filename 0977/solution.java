class Solution {
   public int[] sortedSquares(int[] nums) {
      int l = 0;
      int r = nums.length - 1;
      int[] res = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
         int left = (int) Math.pow(nums[l], 2);
         int right = (int) Math.pow(nums[r], 2);
         if (left > right) {
            res[res.length - i - 1] = left;
            l++;
         } else {
            res[res.length - i - 1] = right;
            r--;
         }
      }
      return res;

   }
}
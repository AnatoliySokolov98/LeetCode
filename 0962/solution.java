class Solution {
   public int maxWidthRamp(int[] nums) {
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < nums.length; i++) {
         if (stack.isEmpty() || nums[stack.getLast()] > nums[i]) {
            stack.push(i);
         }
      }
      int res = 0;
      for (int i = nums.length - 1; i >= 0; i--) {
         while (!stack.isEmpty() && nums[stack.getLast()] <= nums[i]) {
            res = Math.max(res, i - stack.getLast());
            stack.pop();
         }
         if (stack.isEmpty()) {
            return res;
         }
      }
      return res;
   }
}

// time O(n)
// space O(n)

import java.util.HashMap;
import java.util.Map;

class Solution {
   public int subarraysDivByK(int[] nums, int k) {
      Map<Integer, Integer> counts = new HashMap<>();
      counts.put(0, 1);
      int total = 0;
      int res = 0;
      for (int num : nums) {
         total += num;
         int remainder = total % k;
         if (remainder < 0) {
            remainder += k;
         }
         int currCount = counts.getOrDefault(remainder, 0);
         res += currCount;
         counts.put(remainder, currCount + 1);
      }
      return res;
   }
}

// time O(n)
// space O(min(k, n))
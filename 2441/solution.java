import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (cache.contains(-num)) {
                res = Math.max(res, Math.abs(num));
            }
            cache.add(num);
        }
        return res;
    }
}
// time O(n)
// space O(n)

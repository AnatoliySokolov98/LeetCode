import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i]) && i - cache.get(nums[i]) <= k) {
                return true;
            }
            cache.put(nums[i], i);
        }
        return false;
    }
}
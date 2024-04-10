import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mods = new HashMap<>();
        mods.put(0, -1);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = (total + nums[i]) % k;
            if (mods.containsKey(total)) {
                if (i - mods.get(total) > 1)
                    return true;
            } else {
                mods.put(total, i);
            }
        }
        return false;
    }
}
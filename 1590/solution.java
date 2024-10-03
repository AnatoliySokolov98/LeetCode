import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for (int num : nums) {
            total = (total + num) % p;
        }
        if (total % p == 0) {
            return 0;
        }
        int rem = total;
        Map<Integer, Integer> locs = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int curr = 0;
        locs.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            curr = (curr + nums[i]) % p;
            int target = (curr - rem + p) % p;
            if (locs.containsKey(target)) {
                res = Math.min(res, i - locs.get(target));
            }
            locs.put(curr, i);
        }
        return res < nums.length ? res : -1;
    }
}

// time O(n)
// space O(n)
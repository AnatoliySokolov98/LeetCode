import java.util.ArrayList;
import java.util.List;

class Solution {
    int res;
    List<Integer> subset;

    public int beautifulSubsets(int[] nums, int k) {
        res = 0;
        subset = new ArrayList<>();
        backtrack(0, nums, k);
        return res;
    }

    private void backtrack(int i, int[] nums, int k) {
        if (i == nums.length) {
            if (!subset.isEmpty()) {
                res++;
            }
            return;
        }

        boolean valid = true;
        for (int num : subset) {
            if (Math.abs(num - nums[i]) == k) {
                valid = false;
                break;
            }
        }
        if (valid) {
            subset.add(nums[i]);
            backtrack(i + 1, nums, k);
            subset.removeLast();
        }
        backtrack(i + 1, nums, k);
    }
}

// time O(2^n* n)
// space O(n)
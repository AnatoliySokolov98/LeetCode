import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    List<Integer> subset;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        subset = new ArrayList<>();
        backtrack(0, nums);
        return res;
    }

    private void backtrack(int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(i + 1, nums);
        subset.removeLast();
        backtrack(i + 1, nums);
    }
}

// time O(2^n)
// space O(n)
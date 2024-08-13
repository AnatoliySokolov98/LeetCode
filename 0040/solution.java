import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    List<Integer> curr;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target);
        return res;
    }

    private void backtrack(int i, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            // get rid of duplicates
            if (j != i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            if (candidates[j] > target) {
                return;
            }
            curr.add(candidates[j]);
            backtrack(j + 1, candidates, target - candidates[j]);
            curr.removeLast();
        }
    }
}

// time O(2^n)
// space O(target)

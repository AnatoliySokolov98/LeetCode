import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int total = nums[l] + nums[r];
                if (total > target) {
                    r--;
                } else if (total < target) {
                    l++;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(triplet);
                    while (l + 1 < nums.length && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    l++;
                }
            }
        }
        return res;
    }
}
import java.util.Arrays;

class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        return nums[0] == nums[1] || nums[1] == nums[2] ? "isosceles" : "scalene";
    }
}

// time O(1)
// space O(1)
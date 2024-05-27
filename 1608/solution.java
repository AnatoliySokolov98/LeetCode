import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int numsLeft = nums.length - i;
            if (numsLeft == nums[i]) {
                return numsLeft;
            }
            int numBefore = i == 0 ? 0 : nums[i - 1];
            if (numsLeft < nums[i] && numsLeft > numBefore) {
                return numsLeft;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
            i++;
        }
        return -1;
    }
}

// time O(nlogn)
// space O(1)
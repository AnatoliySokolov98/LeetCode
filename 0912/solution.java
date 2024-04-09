import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        return split(nums);
    }

    public int[] split(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int middle = nums.length / 2;
        return merge(split(Arrays.copyOfRange(nums,0, middle)), split(Arrays.copyOfRange(nums, middle,nums.length)));
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0;
        int j1 = 0, j2 = 0;
        while (j1 < nums1.length || j2 < nums2.length) {
            if (j1 == nums1.length) {
                res[i++] = nums2[j2++];
            }
            else if (j2 == nums2.length) {
                res[i++] = nums1[j1++];
            }
            else if (nums1[j1] <= nums2[j2]) {
                res[i++] = nums1[j1++];
            }
            else {
                res[i++] = nums2[j2++];
            }
        }
        return res;
    }
}
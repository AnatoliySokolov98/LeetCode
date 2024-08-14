import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1];
        while (l < r) {
            int p = (r - l) / 2 + l;
            int count = countPairs(nums, p);
            if (count >= k) {
                r = p;
            } else {
                l = p + 1;
            }
        }
        return l;
    }

    private int countPairs(int[] nums, int dist) {
        int res = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (l < r && nums[r] - nums[l] > dist) {
                l++;
            }
            res += r - l;
        }
        return res;
    }
}

// time O(nlogn + nlog(max(n)))
// space O(1)
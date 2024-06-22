class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int l = 0;
        int mid = 0;
        int odds = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            odds += nums[r] % 2;
            if (odds > k) {
                mid++;
                l = mid;
                odds--;
            }
            while (odds == k && nums[mid] % 2 == 0) {
                mid++;
            }
            if (odds == k) {
                res += mid - l + 1;
            }
        }
        return res;
    }
}

// time O(n)
// space O(1)
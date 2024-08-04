import java.util.Arrays;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[(n) * (n + 1) / 2];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums[s++] = sum;
            }
        }
        Arrays.sort(sums);
        int res = 0;
        int MOD = 1_000_000_007;
        for (int i = left - 1; i < right; i++) {
            res = (res + sums[i]) % MOD;
        }
        return res;
    }
}

// time O(n^2(log(n^2)))
// space O(n^2)
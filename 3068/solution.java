class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int totalNums = 0;
        long res = 0;
        int smallestDecrease = Integer.MAX_VALUE;
        int smallestIncrease = Integer.MAX_VALUE;

        for (int num : nums) {
            if ((num ^ k) > num) {
                totalNums++;
                res += num ^ k;
                smallestIncrease = Math.min(smallestIncrease, (num ^ k) - num);
            } else {
                res += num;
                smallestDecrease = Math.min(smallestDecrease, num - (num ^ k));
            }
        }

        if (totalNums % 2 == 0) {
            return res;
        } else {
            return Math.max(res - smallestIncrease, res - smallestDecrease);
        }
    }
}

// time O(n)
// space O(1)
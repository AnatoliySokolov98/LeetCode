class Solution:
    def maximumTotalCost(self, nums: list[int]) -> int:
        dp = [nums[0], nums[0]]
        for i in range(1, len(nums)):
            dp = [max(-nums[i] + dp[1], nums[i] + dp[0]), dp[0] + nums[i]]
        return max(dp)
        # time O(n)
        # space O(1)

class Solution:
    def maximumLength(self, nums: list[int], k: int) -> int:
        dp = [[0 for _ in range(k)] for _ in range(k)]
        res = 0
        for num in nums:
            curr = num % k
            for mod in range(k):
                prev = (mod - curr + k) % k
                dp[curr][mod] = max(dp[curr][mod], 1 + dp[prev][mod])
                res = max(res, dp[curr][mod])
        return res
        # time O(k^2 + n*k)
        # space O(k^2)

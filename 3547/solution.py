from collections import defaultdict
from functools import cache


class Solution:
    def minCost(self, nums: list[int], k: int) -> int:
        @cache
        def dp(i):
            if i == len(nums):
                return 0
            counts = defaultdict(int)
            res = float('inf')
            length = 0
            for j in range(i, len(nums)):
                v = nums[j]
                counts[v] += 1
                if counts[v] == 2:
                    length += 2
                elif counts[v] > 2:
                    length += 1
                res = min(res, length + k + dp(j + 1))
            return res
        return dp(0)
        # time O(n^2)
        # space O(n)
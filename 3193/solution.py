from functools import cache


class Solution:
    def numberOfPermutations(self, n: int, requirements: list[list[int]]) -> int:
        reqs = {x + 1: y for x, y in requirements}
        MOD = 10**9 + 7

        @cache
        def dp(nums, inversions):
            if inversions < 0:
                return 0
            if nums in reqs and reqs[nums] != inversions:
                return 0
            if nums == 1:
                return inversions == 0
            res = 0
            for i in range(nums):
                res += dp(nums - 1, inversions - i)
            return res % MOD

        return dp(n, reqs[n])
        # time O(nums^2 * inversions)
        # space O(nums * inversions)

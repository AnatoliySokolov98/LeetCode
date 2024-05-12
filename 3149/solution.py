from functools import cache


class Solution:
    def findPermutation(self, nums: list[int]) -> list[int]:
        N = len(nums)
        all_used = (1 << N) - 1

        @cache
        def dp(mask, last):
            if mask == all_used:
                return abs(last - nums[0]), [last]
            res = float("inf")
            best_perm = []
            for i in range(1, N):
                if (1 << i) & mask == 0:
                    curr_res, curr_perm = dp(mask | (1 << i), i)
                    curr_res += abs(last - nums[i])
                    if curr_res < res:
                        best_perm = curr_perm
                        res = curr_res
            return res, [last] + best_perm

        return dp(1, 0)[1]

        # time O(2^n * n^2)
        # space O(2^n * n)

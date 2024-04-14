from functools import cache


class Solution:
    def minimumValueSum(self, nums: list[int], andValues: list[int]) -> int:
        BIG_NUM = (1 << 17) - 1

        @cache
        def dp(i, mask, arrays):
            if i == len(nums) and arrays == len(andValues):
                return 0
            if i == len(nums) or arrays == len(andValues):
                return float("inf")
            res = float("inf")
            new_mask = mask & nums[i]
            if new_mask == andValues[arrays]:
                res = nums[i] + dp(i + 1, BIG_NUM, arrays + 1)
            if new_mask >= andValues[arrays]:
                res = min(res, dp(i + 1, new_mask, arrays))
            return res

        res = dp(0, BIG_NUM, 0)
        return res if res != float("inf") else -1
        # time O(n * log(max(nums)) * 10)
        # space O(n * log(max(nums)) * 10)

from math import sqrt


class Solution:
    def longestSquareStreak(self, nums: list[int]) -> int:
        numbers = set(nums)
        res = -1
        for num in nums:
            if sqrt(num) in numbers or num * num not in numbers:
                continue

            curr_count = 0
            curr = num
            while curr in numbers:
                curr_count += 1
                curr = curr * curr

            res = max(res, curr_count)
        return res

        # time O(n)
        # space O(n)

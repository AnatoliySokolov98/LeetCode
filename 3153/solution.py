from collections import defaultdict


class Solution:
    def sumDigitDifferences(self, nums: list[int]) -> int:
        res = 0
        counts = defaultdict(dict)
        for i, num in enumerate(nums):
            j = 0
            while num != 0:
                digit = num % 10
                counts[j][digit] = counts[j].get(digit, 0) + 1
                res += (i + 1) - counts[j][digit]
                num //= 10
                j += 1
        return res

        # time O(n)
        # space O(n)

from collections import defaultdict
from math import ceil


class Solution:
    def medianOfUniquenessArray(self, nums: list[int]) -> int:
        N = len(nums)
        median = ceil(N * (N + 1) / 4)

        def subarrayCount(guess):
            res = 0
            l = 0
            counts = defaultdict(int)
            for r in range(N):
                counts[nums[r]] += 1
                while len(counts) > guess:
                    counts[nums[l]] -= 1
                    if counts[nums[l]] == 0:
                        del counts[nums[l]]
                    l += 1
                res += r - l + 1
            return res

        l, r = 1, len(set(nums))
        while l < r:
            p = (l + r) // 2
            if subarrayCount(p) >= median:
                r = p
            else:
                l = p + 1
        return r

        # time O(nlog(n))
        # space O(n)

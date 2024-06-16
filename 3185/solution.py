from collections import defaultdict


class Solution:
    def countCompleteDayPairs(self, hours: list[int]) -> int:
        counts = defaultdict(int)
        res = 0
        for hour in hours:
            modded = hour % 24
            complement = (24 - modded) % 24
            res += counts[complement]
            counts[modded] += 1
        return res
        # time O(n)
        # time O(n)

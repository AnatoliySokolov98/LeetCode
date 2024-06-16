from collections import Counter
from functools import cache


class Solution:
    def maximumTotalDamage(self, power: list[int]) -> int:
        counts = Counter(power)
        spells = sorted(counts.keys())

        @cache
        def dp(i):
            if i == len(spells):
                return 0
            j = i + 1
            while j < len(spells) and spells[j] - spells[i] <= 2:
                j += 1
            res = max(dp(i + 1), spells[i] * counts[spells[i]] + dp(j))
            return res

        return dp(0)
        # time O(nlogn)
        # space O(n)

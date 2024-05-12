from collections import defaultdict
from functools import cache


class Solution:
    def minimumSubstringsInPartition(self, s: str) -> int:
        @cache
        def dp(i):
            if i == len(s):
                return 0
            counts = defaultdict(int)
            max_count = 0
            count = 0
            res = float("inf")
            for j in range(i, len(s)):
                counts[s[j]] += 1
                if counts[s[j]] > max_count:
                    max_count = counts[s[j]]
                    count = 1
                elif counts[s[j]] == max_count:
                    count += 1
                if count == len(counts):
                    res = min(res, 1 + dp(j + 1))
            return res

        return dp(0)

        # O(n^2)
        # O(n)

from collections import defaultdict


class Solution:
    def findPermutationDifference(self, s: str, t: str) -> int:
        s_locs = defaultdict(int)
        res = 0
        for i in range(len(s)):
            s_locs[s[i]] = i
        for i in range(len(t)):
            res += abs(s_locs[t[i]] - i)
        return res

        # O(1)
        # O(26)

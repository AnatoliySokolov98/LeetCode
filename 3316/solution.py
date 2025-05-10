from functools import cache


class Solution:
    def maxRemovals(self, source: str, pattern: str, targetIndices: list[int]) -> int:
        targetIndices = set(targetIndices)
        S, P = len(source), len(pattern)
        @cache
        def dp(s, p):
            if s == S:
                if p == P:
                    return 0
                return float('-inf')
            res = float('-inf')
            if s in targetIndices:
                res = max(res, 1 + dp(s + 1, p))
            if p < P and source[s] == pattern[p]:
                res = max(res, dp(s + 1, p + 1))
            else:
                res = max(res, dp(s + 1, p))
            return res
        return dp(0,0)
        # time O(mn)
        # space O(mn)
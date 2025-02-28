from functools import cache


class Solution:
    def shortestCommonSupersequence(self, s1: str, s2: str) -> str:
        m, n = len(s1), len(s2)

        @cache
        def dp(i, j):
            if i == m:
                return n - j
            if j == n:
                return m - i
            if s1[i] == s2[j]:
                return 1 + dp(i + 1, j + 1)
            return 1 + min(dp(i + 1, j), dp(i, j + 1))

        res = []
        i, j = 0, 0
        while i < m or j < n:
            if i == m:
                res.append(s2[j])
                j += 1
            elif j == n:
                res.append(s1[i])
                i += 1
            elif s1[i] == s2[j]:
                res.append(s1[i])
                i += 1
                j += 1
            elif dp(i + 1, j) < dp(i, j + 1):
                res.append(s1[i])
                i += 1
            else:
                res.append(s2[j])
                j += 1
        return "".join(res)

        # time O(mn)
        # space O(mn)

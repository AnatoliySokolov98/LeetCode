from functools import cache


class Solution:
    def strangePrinter(self, s):
        s = "".join(
            [char for i, char in enumerate(list(s)) if i == 0 or s[i] != s[i - 1]]
        )

        @cache
        def dp(i, j):
            if i > j:
                return 0
            res = 1 + dp(i + 1, j)
            for k in range(i + 1, j + 1):
                if s[i] == s[k]:
                    res = min(res, dp(i + 1, k) + dp(k + 1, j))
            return res

        return dp(0, len(s) - 1)

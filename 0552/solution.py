from functools import cache


class Solution:
    def checkRecord(self, n: int) -> int:
        MOD = 10**9 + 7

        @cache
        def dp(i, absent_count, late_streak):
            if i == n:
                return 1
            res = 0
            if absent_count == 0:
                res += dp(i + 1, 1, 0)
                res %= MOD
            if late_streak < 2:
                res += dp(i + 1, absent_count, late_streak + 1)
                res %= MOD
            res += dp(i + 1, absent_count, 0)
            res %= MOD
            return res

        return dp(0, 0, 0)

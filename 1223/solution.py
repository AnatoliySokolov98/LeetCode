from functools import cache


class Solution:
    def dieSimulator(self, n: int, rollMax: list[int]) -> int:
        MOD = 10**9 + 7
        ROLLS = 6
        @cache
        def dp(n, last_roll, roll_count):
            if not n:
                return 1
            res = 0
            for i in range(ROLLS):
                if i != last_roll:   
                    res += dp(n - 1, i, 1)
                elif  roll_count < rollMax[i]:
                    res += dp(n - 1, last_roll, roll_count + 1)
            return res % MOD
        return dp(n, 0, 0) % MOD
        # time (n * max(rollMax) * rolls ^ 2)
        # space (n * max(rollMax) * rolls)

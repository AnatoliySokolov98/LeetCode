class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        MOD = 10**9 + 7
        ROWS, COLS = zero + 1, one + 1
        dp = [[[0, 0] for i in range(COLS)] for j in range(ROWS)]
        for row in range(min(ROWS, limit + 1)):
            dp[row][0][0] += 1
        for col in range(min(COLS, limit + 1)):
            dp[0][col][1] += 1
        for row in range(1, ROWS):
            for col in range(1, COLS):
                dp[row][col][0] = sum(dp[row - 1][col])
                dp[row][col][1] = sum(dp[row][col - 1])
                if row > limit:
                    dp[row][col][0] -= dp[row - limit - 1][col][1]
                if col > limit:
                    dp[row][col][1] -= dp[row][col - limit - 1][0]
                dp[row][col][0] %= MOD
                dp[row][col][1] %= MOD
        return sum(dp[ROWS - 1][COLS - 1]) % MOD

        # time (zero * one)
        # space (zero * one)

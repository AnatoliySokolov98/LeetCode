from functools import cache


class Solution:
    def stoneGameII(self, piles: list[int]) -> int:
        @cache
        def dp(index, M, turn):
            if index >= len(piles):
                return 0

            # alice ==1 bob== 0
            if turn == 1:
                res = 0
            else:
                res = float("inf")

            stones = 0
            for X in range(2 * M):
                if index + X >= len(piles):
                    break
                stones += piles[X + index]
                if turn == 1:
                    res = max(res, stones + dp(index + X + 1, max(M, X + 1), 0))
                else:
                    res = min(res, dp(index + X + 1, max(M, X + 1), 1))
            return res

        return dp(0, 1, 1)

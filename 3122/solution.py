from collections import defaultdict
from functools import cache


class Solution:
    def minimumOperations(self, grid: list[list[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        counts = {}
        for col in range(COLS):
            counts[col] = defaultdict(int)
            for row in range(ROWS):
                counts[col][grid[row][col]] += 1

        @cache
        def dp(i, last):
            if i == COLS:
                return 0
            res = float("inf")
            for j in range(10):
                if j == last:
                    continue
                res = min(res, ROWS - counts[i][j] + dp(i + 1, j))
            return res

        return dp(0, -1)

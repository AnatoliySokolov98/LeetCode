from functools import cache


class Solution:
    def minimumSum(self, grid: list[list[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        res = ROWS * COLS

        @cache
        def dp(x0, x1, y0, y1):
            l, r, u, d = float("inf"), float("-inf"), float("inf"), float("-inf")
            for x in range(x0, x1):
                for y in range(y0, y1):
                    if grid[y][x]:
                        l = min(l, x)
                        r = max(r, x)
                        u = min(u, y)
                        d = max(d, y)
            return max(0, (r - l + 1) * (d - u + 1))

        for x in range(1, COLS):
            for y in range(1, ROWS):
                # 1 top, 2 bot
                res = min(
                    res, dp(0, COLS, 0, y) + dp(0, x, y, ROWS) + dp(x, COLS, y, ROWS)
                )
                # 2 top, 1 bot
                res = min(
                    res, dp(0, x, 0, y) + dp(x, COLS, 0, y) + dp(0, COLS, y, ROWS)
                )
                # 2 left, 1 right
                res = min(
                    res, dp(0, x, 0, y) + dp(0, x, y, ROWS) + dp(x, COLS, 0, ROWS)
                )
                # 2 1 left, 2 right
                res = min(
                    res, dp(0, x, 0, ROWS) + dp(x, COLS, 0, y) + dp(x, COLS, y, ROWS)
                )

        # 3 left to right
        for x1 in range(1, COLS - 1):
            for x2 in range(x1 + 1, COLS):
                res = min(
                    res,
                    dp(0, x1, 0, ROWS) + dp(x1, x2, 0, ROWS) + dp(x2, COLS, 0, ROWS),
                )

        # 3 up to down
        for y1 in range(1, ROWS - 1):
            for y2 in range(y1 + 1, ROWS):
                res = min(
                    res,
                    dp(0, COLS, 0, y1) + dp(0, COLS, y1, y2) + dp(0, COLS, y2, ROWS),
                )
        return res

        # time O(n^2 * m^2 + mn^3 + nm^3)
        # space O(n^2m^2)

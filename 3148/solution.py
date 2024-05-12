class Solution:
    def maxScore(self, grid: list[list[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        res = float("-inf")
        cache = {}
        for row in range(ROWS):
            for col in range(COLS):
                top = (
                    min(cache[(row - 1, col)], grid[row - 1][col])
                    if row != 0
                    else float("inf")
                )
                left = (
                    min(cache[(row, col - 1)], grid[row][col - 1])
                    if col != 0
                    else float("inf")
                )
                cache[(row, col)] = min(top, left)
                res = max(res, grid[row][col] - cache[(row, col)])
        return res

        # time O(n*m)
        # space O(n*m)

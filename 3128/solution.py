from collections import defaultdict


class Solution:
    def numberOfRightTriangles(self, grid: list[list[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        row_counts = defaultdict(int)
        col_counts = defaultdict(int)
        for row in range(ROWS):
            for col in range(COLS):
                if grid[row][col] == 1:
                    row_counts[row] += 1
                    col_counts[col] += 1

        res = 0
        for row in range(ROWS):
            for col in range(COLS):
                if grid[row][col] == 1:
                    res += (row_counts[row] - 1) * (col_counts[col] - 1)
        return res

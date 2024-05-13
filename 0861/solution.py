class Solution:
    def matrixScore(self, grid: list[list[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        res = (1 << (COLS - 1)) * ROWS
        for col in range(1, COLS):
            col_total = 0
            for row in range(ROWS):
                col_total += grid[row][col] if grid[row][0] == 1 else 1 - grid[row][col]
            col_total = max(col_total, ROWS - col_total)
            res += (1 << (COLS - 1 - col)) * col_total
        return res

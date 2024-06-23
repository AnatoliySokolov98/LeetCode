class Solution:
    def minimumArea(self, grid: list[list[int]]) -> int:
        x0 = float("inf")
        x1 = float("-inf")
        y0 = float("inf")
        y1 = float("-inf")
        ROWS, COLS = len(grid), len(grid[0])
        for row in range(ROWS):
            for col in range(COLS):
                if grid[row][col] == 1:
                    x0 = min(x0, row)
                    x1 = max(x1, row)
                    y0 = min(y0, col)
                    y1 = max(y1, col)
        return (x1 - x0 + 1) * (y1 - y0 + 1)
        # time O(nm)
        # space O(1)

class Solution:
    def satisfiesConditions(self, grid: list[list[int]]) -> bool:
        ROWS, COLS = len(grid), len(grid[0])
        for col in range(COLS - 1):
            if grid[0][col] == grid[0][col + 1]:
                return False
        for col in range(COLS):
            for row in range(ROWS - 1):
                if grid[row][col] != grid[row + 1][col]:
                    return False
        return True

        # time O(n*m)
        # space O(1)

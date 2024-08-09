class Solution:
    def numMagicSquaresInside(self, grid: list[list[int]]) -> int:
        def isValidSquare(x, y):
            nums = set()
            s = 15
            if grid[x + 1][y + 1] != 5:
                return False
            for r in range(3):
                if sum(grid[x + r][y : y + 3]) != s:  # Check row sum
                    return False
                for c in range(3):
                    val = grid[x + r][y + c]
                    if val < 1 or val > 9 or val in nums:
                        return False
                    nums.add(val)
            for c in range(3):
                if sum(grid[x + r][y + c] for r in range(3)) != s:
                    return False
            if (
                sum(grid[x + i][y + i] for i in range(3)) != s
                or sum(grid[x + i][y + 2 - i] for i in range(3)) != s
            ):
                return False
            return True

        ROWS, COLS = len(grid), len(grid[0])
        res = 0
        for r in range(ROWS - 2):
            for c in range(COLS - 2):
                if isValidSquare(r, c):
                    res += 1
        return res

class Solution:
    def getMaximumGold(self, grid: list[list[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        total_gold = sum([sum(grid[i]) for i in range(ROWS)])
        res = 0
        visited = set()

        def dfs(row, col):
            if (
                row < 0
                or row == ROWS
                or col < 0
                or col == COLS
                or (row, col) in visited
                or grid[row][col] == 0
            ):
                return 0
            visited.add((row, col))
            total = grid[row][col]
            for x, y in dirs:
                total = max(total, grid[row][col] + dfs(row + x, col + y))
                if total == total_gold:
                    return total
            visited.remove((row, col))
            return total

        for row in range(ROWS):
            for col in range(COLS):
                res = max(res, dfs(row, col))
                if res == total_gold:
                    return res
        return res

class Solution:
    def regionsBySlashes(self, grid: list[str]) -> int:
        N = len(grid)
        new_grid = [[0 for _ in range(N * 3)] for _ in range(N * 3)]

        for r in range(N):
            for c in range(N):
                if grid[r][c] == "/":
                    new_grid[r * 3][c * 3 + 2] = 1
                    new_grid[r * 3 + 1][c * 3 + 1] = 1
                    new_grid[r * 3 + 2][c * 3] = 1
                elif grid[r][c] == "\\":
                    new_grid[r * 3][c * 3] = 1
                    new_grid[r * 3 + 1][c * 3 + 1] = 1
                    new_grid[r * 3 + 2][c * 3 + 2] = 1

        def dfs(r, c):
            if (
                r < 0
                or r >= len(new_grid)
                or c < 0
                or c >= len(new_grid)
                or new_grid[r][c] == 1
            ):
                return
            new_grid[r][c] = 1
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        res = 0
        for r in range(len(new_grid)):
            for c in range(len(new_grid)):
                if new_grid[r][c] == 0:
                    res += 1
                    dfs(r, c)

        return res

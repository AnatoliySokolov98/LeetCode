class Solution:
    def gridGame(self, grid: list[list[int]]) -> int:
        ps = grid.copy()
        ROWS, COLS = 2, len(grid[0])
        for i in range(1, COLS):
            ps[0][i] += ps[0][i - 1]
            ps[1][i] += ps[1][i - 1]

        res = ps[0][-1] - ps[0][0]

        for i in range(1, COLS):
            top = ps[0][-1] - ps[0][i]
            bottom = ps[1][i - 1]
            res = min(res, max(top, bottom))
        return res

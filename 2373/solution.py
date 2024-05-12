class Solution:
    def largestLocal(self, grid: list[list[int]]) -> list[list[int]]:
        N = len(grid)
        res = [[0 for col in range(N - 2)] for row in range(N - 2)]
        for row in range(N - 2):
            for col in range(N - 2):
                for i in range(-1, 2):
                    for j in range(-1, 2):
                        res[row][col] = max(
                            res[row][col], grid[row + i + 1][col + j + 1]
                        )
        return res

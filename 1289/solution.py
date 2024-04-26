from heapq import heappush, heappop


class Solution:
    def minFallingPathSum(self, grid: list[list[int]]) -> int:
        N = len(grid)
        if N == 1:
            return grid[0][0]
        old_row = [[0, -1], [0, -2]]
        for row in range(N - 1, -1, -1):
            new_row = []
            for col in range(N):
                if col != old_row[1][1]:
                    curr = grid[row][col] + -old_row[1][0]
                else:
                    curr = grid[row][col] + -old_row[0][0]
                heappush(new_row, [-curr, col])
                if len(new_row) > 2:
                    heappop(new_row)
            old_row = new_row
        return -old_row[1][0]

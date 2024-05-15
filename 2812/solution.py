from collections import deque
from heapq import heappop, heappush


class Solution:
    def maximumSafenessFactor(self, grid: list[list[int]]) -> int:
        N = len(grid)
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        safety = [[-1 for _ in range(N)] for _ in range(N)]
        bfs = deque()
        for row in range(N):
            for col in range(N):
                if grid[row][col] == 1:
                    bfs.append([row, col, 0])
                    safety[row][col] = 0
        while bfs:
            row, col, dist = bfs.popleft()
            for x, y in directions:
                r, c = row + x, col + y
                if r < 0 or r == N or c < 0 or c == N or safety[r][c] != -1:
                    continue
                safety[r][c] = dist + 1
                bfs.append([r, c, dist + 1])
        visited = set()
        heap = [[-safety[0][0], 0, 0]]
        while heap:
            safeness, row, col = heappop(heap)
            safeness *= -1
            if row == N - 1 and col == N - 1:
                return safeness
            if (row, col) in visited:
                continue
            visited.add((row, col))
            for x, y in directions:
                r, c = row + x, col + y
                if r < 0 or r == N or c < 0 or c == N or (r, c) in visited:
                    continue
                heappush(heap, [-1 * min(safety[r][c], safeness), r, c])
        return -1

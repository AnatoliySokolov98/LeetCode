from heapq import heapify, heappop, heappush


class Solution:
    def trapRainWater(self, h: list[list[int]]) -> int:
        ROWS, COLS = len(h), len(h[0])
        visited = set()
        res = 0
        heap = []
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        for c in range(COLS):
            heap.append([h[0][c], 0, c])
            heap.append([h[ROWS - 1][c], ROWS - 1, c])
            visited.add((0, c))
            visited.add((ROWS - 1, c))
        for r in range(1, ROWS - 1):
            heap.append([h[r][0], r, 0])
            heap.append([h[r][COLS - 1], r, COLS - 1])
            visited.add((r, 0))
            visited.add((r, COLS - 1))
        heapify(heap)
        while heap:
            height, x, y = heappop(heap)
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if nx < 0 or nx >= ROWS or ny < 0 or ny >= COLS or (nx, ny) in visited:
                    continue
                visited.add((nx, ny))
                water = max(0, height - h[nx][ny])
                res += water
                heappush(heap, [max(height, h[nx][ny]), nx, ny])
        return res

        # time O(mnlogmn)
        # space O(mn)

class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        ROWS, COLS = len(grid), len(grid[0])
        bfs = deque()
        bfs.append([grid[0][0], 0, 0])
        visited = set()
        visited.add((0, 0))
        while bfs:
            dist, x, y = bfs.popleft()
            if x == ROWS - 1 and y == COLS - 1:
                return dist
            for r, c in directions:
                X = x + r
                Y = y + c
                if X < 0 or X == ROWS or Y < 0 or Y == COLS or (X, Y) in visited:
                    continue
                if grid[X][Y] == 0:
                    bfs.appendleft([dist, X, Y])
                else:
                    bfs.append([dist + 1, X, Y])
                visited.add((X, Y))
        return -1

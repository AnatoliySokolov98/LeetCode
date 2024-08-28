class Solution:
    def countSubIslands(self, grid1: list[list[int]], grid2: list[list[int]]) -> int:
        res = 0
        visited = set()
        ROWS, COLS = len(grid1), len(grid1[0])
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        for row in range(ROWS):
            for col in range(COLS):
                if (row, col) in visited or grid2[row][col] == 0:
                    continue
                islands = []
                islands.append([row, col])
                sub = True
                while islands:
                    r, c = islands.pop()
                    if (r, c) not in visited:
                        visited.add((r, c))
                        if grid1[r][c] == 0:
                            sub = False
                        for x, y in directions:
                            nr, nc = r + x, c + y
                            if (
                                0 <= nr < ROWS
                                and 0 <= nc < COLS
                                and (nr, nc) not in visited
                                and grid2[nr][nc] == 1
                            ):
                                islands.append([nr, nc])
                if sub:
                    res += 1
        return res

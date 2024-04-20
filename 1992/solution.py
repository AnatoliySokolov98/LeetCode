class Solution:
    def findFarmland(self, land: list[list[int]]) -> list[list[int]]:
        visited = set()
        ROWS, COLS = len(land), len(land[0])
        res = []
        for row in range(ROWS):
            for col in range(COLS):
                if land[row][col] == 1 and (row, col) not in visited:
                    for r in range(row, ROWS):
                        if land[r][col] == 0:
                            break
                        for c in range(col, COLS):
                            if land[r][c] == 0:
                                break
                            visited.add((r, c))
                            r2, c2 = r, c
                    res.append([row, col, r2, c2])
        return res

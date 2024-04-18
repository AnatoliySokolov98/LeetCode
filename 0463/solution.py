class Solution:
    def islandPerimeter(self, grid: list[list[int]]) -> int:
        ROWS, COLUMNS = len(grid), len(grid[0])
        res = 0
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        for row in range(ROWS):
            for column in range(COLUMNS):
                if grid[row][column] == 1:
                    for direction in directions:
                        new_row, new_column = row + direction[0], column + direction[1]
                        if (
                            new_row < 0
                            or new_row >= ROWS
                            or new_column < 0
                            or new_column >= COLUMNS
                            or grid[new_row][new_column] == 0
                        ):
                            res += 1
        return res


# time O(row * col)
# space O(1)

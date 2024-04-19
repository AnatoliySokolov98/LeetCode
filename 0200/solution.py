class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        ROWS, COLUMNS = len(grid), len(grid[0])
        res = 0

        def dfs(row, column):
            if (
                row < 0
                or row >= ROWS
                or column < 0
                or column >= COLUMNS
                or grid[row][column] != "1"
            ):
                return

            grid[row][column] = "2"

            for direction in directions:
                n_row, n_col = row + direction[0], column + direction[1]
                dfs(n_row, n_col)

        for row in range(ROWS):
            for column in range(COLUMNS):
                if grid[row][column] == "1":
                    res += 1
                    dfs(row, column)
        return res

        # time O(m*n)
        # space O(1) O(m*n)

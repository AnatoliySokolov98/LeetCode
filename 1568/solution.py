class Solution:
    def minDays(self, grid: list[list[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        islands = 0
        visited = set()

        def dfs(row, col, visited):
            if (
                row < 0
                or row == ROWS
                or col < 0
                or col == COLS
                or (row, col) in visited
                or grid[row][col] == 0
            ):
                return
            visited.add((row, col))
            for x, y in directions:
                dfs(row + x, col + y, visited)

        # Count the number of islands
        for row in range(ROWS):
            for col in range(COLS):
                if grid[row][col] == 1 and (row, col) not in visited:
                    islands += 1
                    dfs(row, col, visited)

        if islands != 1:
            return 0
        if len(visited) <= 2:
            return len(visited)

        min_connections = float("inf")
        land_cells = 0

        # Calculate the minimum connections for any land cell
        for row in range(ROWS):
            for col in range(COLS):
                if (row, col) in visited:
                    land_cells += 1
                    connections = 0
                    for x, y in directions:
                        newRow, newCol = row + x, col + y
                        if (
                            0 <= newRow < ROWS
                            and 0 <= newCol < COLS
                            and grid[newRow][newCol] == 1
                        ):
                            connections += 1
                    min_connections = min(min_connections, connections)

        if min_connections == 1:
            return 1

        # Check if removing one land cell disconnects the island
        for x, y in visited:
            for r, c in directions:
                nr, nc = x + r, y + c
                if nr < 0 or nr == ROWS or nc < 0 or nc == COLS or grid[nr][nc] == 0:
                    continue
                else:
                    grid[x][y] = 0
                    new_visited = set()
                    dfs(nr, nc, new_visited)
                    if len(new_visited) != len(visited) - 1:
                        return 1
                    grid[x][y] = 1

        return 2

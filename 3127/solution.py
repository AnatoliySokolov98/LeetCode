class Solution:
    def canMakeSquare(self, grid: list[list[str]]) -> bool:
        for row in range(2):
            for col in range(2):
                total = 0
                total += 1 if grid[row][col] == "W" else -1
                total += 1 if grid[row + 1][col] == "W" else -1
                total += 1 if grid[row][col + 1] == "W" else -1
                total += 1 if grid[row + 1][col + 1] == "W" else -1
                if abs(total) >= 2:
                    return True
        return False

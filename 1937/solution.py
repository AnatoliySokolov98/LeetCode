class Solution:
    def maxPoints(self, points: list[list[int]]) -> int:
        ROWS, COLS = len(points), len(points[0])
        prevRow = points[0][:]
        for i in range(1, ROWS):
            newRow = [0] * COLS
            l = 0
            for j in range(COLS):
                l = max(l - 1, prevRow[j])
                newRow[j] = points[i][j] + l
            r = 0
            for j in range(COLS - 1, -1, -1):
                r = max(r - 1, prevRow[j])
                newRow[j] = max(newRow[j], points[i][j] + r)
            prevRow = newRow
        return max(prevRow)

class Solution:
    def restoreMatrix(self, rowSum: list[int], colSum: list[int]) -> list[list[int]]:
        ROWS, COLS = len(rowSum), len(colSum)
        res = [[0 for _ in range(COLS)] for _ in range(ROWS)]
        for row in range(ROWS):
            for col in range(COLS):
                res[row][col] = min(rowSum[row], colSum[col])
                rowSum[row] -= res[row][col]
                colSum[col] -= res[row][col]
        return res

class Solution:
    def getRow(self, rowIndex: int) -> list[int]:
        row = [1]
        for i in range(rowIndex):
            row = [1] + [row[j] + row[j + 1] for j in range(i)] + [1]
        return row

    # time O(n^2)
    # space O(n)

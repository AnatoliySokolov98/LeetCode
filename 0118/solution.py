class Solution:
    def generate(self, numRows: int) -> list[list[int]]:
        res = [[1]]
        for row in range(1, numRows):
            res.append([1])
            for col in range(len(res[-2]) - 1):
                res[-1].append(res[-2][col] + res[-2][col + 1])
            res[-1].append(1)
        return res

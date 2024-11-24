class Solution:
    def maxMatrixSum(self, matrix: list[list[int]]) -> int:
        smallest = float("inf")
        res = 0
        negatives = 0
        for row in matrix:
            for num in row:
                res += abs(num)
                negatives += num < 0
                smallest = min(smallest, abs(num))
        return res if negatives % 2 == 0 else res - 2 * smallest

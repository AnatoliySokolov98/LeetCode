class Solution:
    def coloredCells(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 5
        return 2 * pow(n, 2) - 2 * n + 1

        # time O(log(n))
        # space O(1)

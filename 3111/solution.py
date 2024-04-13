class Solution:
    def minRectanglesToCoverPoints(self, points: list[list[int]], w: int) -> int:
        points.sort()
        res = 0
        start = float("-inf")
        for x, _ in points:
            if x - start <= w:
                continue
            res += 1
            start = x
        return res

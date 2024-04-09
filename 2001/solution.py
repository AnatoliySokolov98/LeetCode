from collections import defaultdict


class Solution:
    def interchangeableRectangles(self, rectangles: list[list[int]]) -> int:
        counts = defaultdict(int)
        res = 0
        for width, height in rectangles:
            counts[width / height] += 1

        for value in counts.values():
            res += value * (value - 1) // 2

        return res

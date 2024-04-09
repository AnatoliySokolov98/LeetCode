from collections import defaultdict


class Solution:
    def leastBricks(self, wall: list[list[int]]) -> int:
        cuts = defaultdict(int)
        for row in wall:
            total = 0
            for brick in row[:-1]:
                total += brick
                cuts[total] += 1
        if not cuts:
            return len(wall)
        return len(wall) - max(cuts.values())

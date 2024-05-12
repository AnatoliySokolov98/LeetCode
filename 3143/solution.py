class Solution:
    def maxPointsInsideSquare(self, points: list[list[int]], s: str) -> int:
        S = len(s)
        groups = sorted(
            [(max(abs(points[i][0]), abs(points[i][1])), s[i]) for i in range(S)]
        )
        res = 0
        visited = set()
        i = 0
        while i < S:
            curr = 0
            point = groups[i][0]
            while i < S and groups[i][0] == point:
                if groups[i][1] in visited:
                    return res
                visited.add(groups[i][1])
                curr += 1
                i += 1
            res += curr
        return res

        # time O(nlogn)
        # space O(n)

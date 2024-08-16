class Solution:
    def maxDistance(self, arrays: list[list[int]]) -> int:
        small, big = arrays[0][0], arrays[0][-1]
        res = 0
        for i in range(1, len(arrays)):
            currs, currb = arrays[i][0], arrays[i][-1]
            res = max(res, currb - small, big - currs)
            small, big = min(small, currs), max(big, currb)
        return res

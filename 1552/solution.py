class Solution:
    def maxDistance(self, position: list[int], m: int) -> int:
        position.sort()

        def canPlace(dist):
            res = 0
            last = float("-inf")
            for pos in position:
                if pos - last >= dist:
                    last = pos
                    res += 1
                    if res == m:
                        return True
            return False

        l, r = 1, max(position)
        res = l
        while l <= r:
            p = (l + r) // 2
            if canPlace(p):
                res = p
                l = p + 1
            else:
                r = p - 1
        return res

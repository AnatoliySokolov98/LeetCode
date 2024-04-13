class Solution:
    def mySqrt(self, x: int) -> int:
        if x <= 1:
            return x
        l, r = 1, x // 2
        res = 1
        while l <= r:
            p = (l + r) // 2
            square = p * p
            if square == x:
                return p
            if square < x:
                res = p
                l = p + 1
            else:
                r = p - 1
        return res

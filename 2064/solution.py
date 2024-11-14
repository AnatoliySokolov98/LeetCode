from math import ceil


class Solution:
    def minimizedMaximum(self, n: int, quantities: list[int]) -> int:
        def can_split(max_val):
            return sum(ceil(num / max_val) for num in quantities) <= n

        l, r = 1, max(quantities)
        res = None
        while l <= r:
            p = (l + r) // 2
            if can_split(p):
                res = p
                r = p - 1
            else:
                l = p + 1
        return res

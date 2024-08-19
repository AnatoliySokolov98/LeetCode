from math import ceil, sqrt


class Solution:
    def minSteps(self, n: int) -> int:
        factor = 2
        res = 0
        root = ceil(sqrt(n))
        while factor <= root:
            while n % factor == 0:
                res += factor
                n //= factor
            factor += 1
        return res if n == 1 else res + n

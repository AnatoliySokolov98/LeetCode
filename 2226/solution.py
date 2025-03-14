class Solution:
    def maximumCandies(self, candies: list[int], k: int) -> int:
        l, r = 1, sum(candies) // k
        res = 0

        def check(num):
            total = 0
            for c in candies:
                total += c // num
            return total >= k

        while l <= r:
            p = (l + r) // 2
            if check(p):
                res = p
                l = p + 1
            else:
                r = p - 1
        return res

class Solution:
    def maximumTastiness(self, price: list[int], k: int) -> int:
        price.sort()
        l, r = 0, price[-1]
        res = 0
        def isPossible(diff):
            count = 1
            curr = price[0]
            for i in range(1, len(price)):
                if price[i] - curr >= diff:
                    count += 1
                    curr = price[i]
            return count >= k
        while l <= r:
            p = (l + r) // 2
            if isPossible(p):
                res = p
                l = p + 1
            else:
                r = p - 1
        return res
        #time O(nlogn + nlog(max(price)))
        #space O(1)
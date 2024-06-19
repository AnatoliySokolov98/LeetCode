class Solution:
    def minDays(self, bloomDay: list[int], m: int, k: int) -> int:
        B = len(bloomDay)

        def bouquets(day):
            res = 0
            curr = 0
            for flower in bloomDay:
                if flower <= day:
                    curr += 1
                else:
                    curr = 0
                if curr == k:
                    res += 1
                    curr = 0
                    if res == m:
                        return True
            return False

        if m * k > B:
            return -1
        res = max(bloomDay)
        l, r = 1, res
        while l <= r:
            p = (l + r) // 2
            if bouquets(p):
                res = p
                r = p - 1
            else:
                l = p + 1
        return res

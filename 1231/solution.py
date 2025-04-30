class Solution:
    def maximizeSweetness(self, s: list[int], k: int) -> int:
        k += 1
        def check(target):
            chunks = 0
            total = 0
            for num in s:
                total += num
                if total >= target:
                    chunks +=1
                    total = 0
            return chunks >= k
        l, r = min(s), sum(s)
        res = l
        while l <= r:
            p = (l + r) // 2
            if check(p):
                res = p
                l = p + 1
            else:
                r = p - 1
        return res

        #time O(n * log(sum(n)))
        #space O(1)
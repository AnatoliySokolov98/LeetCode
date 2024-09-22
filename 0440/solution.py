class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        k -= 1
        curr = 1

        def subtreeNodes(num):
            res = 0
            nextNum = num + 1
            while num <= n:
                res += min(n - num + 1, nextNum - num)
                num *= 10
                nextNum *= 10
            return res

        while k:
            count = subtreeNodes(curr)
            if k >= count:
                curr += 1
                k -= count
            else:
                curr *= 10
                k -= 1
        return curr

class Solution:
    def minEnd(self, n: int, x: int) -> int:
        n -= 1
        i = 0
        while n > 0:
            bit = n & 1
            while (1 << i) & x:
                i += 1
            x |= bit << i
            i += 1
            n >>= 1
        return x

        # time log(n) + log(x)
        # space O(1)

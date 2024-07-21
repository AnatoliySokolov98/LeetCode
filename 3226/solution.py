class Solution:
    def minChanges(self, n: int, k: int) -> int:
        res = 0
        while n or k:
            n_bit = n & 1
            k_bit = k & 1
            if k_bit and not n_bit:
                return -1
            if n_bit and not k_bit:
                res += 1
            n >>= 1
            k >>= 1
        return res

        # time O(n)
        # space O(1)

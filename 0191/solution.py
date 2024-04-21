class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n != 0:
            res += n % 2
            n //= 2
        return res

        # time O(1)
        # space O(1)

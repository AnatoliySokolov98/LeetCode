class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        xor = start ^ goal
        res = 0
        while xor:
            res += xor & 1
            xor >>= 1
        return res

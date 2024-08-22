class Solution:
    def findComplement(self, num: int) -> int:
        bits = 0
        res = num
        while num:
            num >>= 1
            bits <<= 1
            bits += 1
        return bits - res

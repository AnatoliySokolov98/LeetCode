class Solution:
    def singleNumber(self, nums: list[int]) -> list[int]:
        xor = 0
        for num in nums:
            xor ^= num
        bit = 0
        for i in range(32):
            if (1 << i) & xor:
                bit = 1 << i
                break
        first = 0
        for num in nums:
            if num & bit:
                first ^= num
        return [first, xor ^ first]

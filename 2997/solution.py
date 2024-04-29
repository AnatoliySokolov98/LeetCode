class Solution:
    def minOperations(self, nums: list[int], k: int) -> int:
        xor = 0
        for num in nums:
            xor ^= num
        xor ^= k
        res = 0
        while xor > 0:
            res += xor & 1
            xor >>= 1
        return res

        # time O(n)
        # space O(1)

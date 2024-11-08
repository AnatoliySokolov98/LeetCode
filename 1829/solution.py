class Solution:
    def getMaximumXor(self, nums: list[int], k: int) -> list[int]:
        xor = 0
        for num in nums:
            xor ^= num
        res = []
        complement = pow(2, k) - 1
        for i in range(len(nums) - 1, -1, -1):
            res.append(xor ^ complement)
            xor ^= nums[i]
        return res

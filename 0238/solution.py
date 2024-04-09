class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        res = [1] * len(nums)
        for i in range(len(nums) - 2, -1, -1):
            res[i] = res[i + 1] * nums[i + 1]
        left = 1
        for i in range(1, len(nums)):
            left *= nums[i - 1]
            res[i] *= left
        return res

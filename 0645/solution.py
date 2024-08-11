class Solution:
    def findErrorNums(self, nums: list[int]) -> list[int]:
        for v in nums:
            nums[(v - 1) % 10_000] += 10_000
        res = [0, 0]
        for i, v in enumerate(nums):
            if v > 20_000:
                res[0] = i + 1
            if v < 10_000:
                res[1] = i + 1
        return res

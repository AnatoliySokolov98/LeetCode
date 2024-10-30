class Solution:
    def minimumMountainRemovals(self, nums: list[int]) -> int:
        lefts = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    lefts[i] = max(1 + lefts[j], lefts[i])

        rights = [1] * len(nums)
        for i in range(len(nums) - 1, -1, -1):
            for j in range(len(nums) - 1, i, -1):
                if nums[i] > nums[j]:
                    rights[i] = max(1 + rights[j], rights[i])
        res = float("inf")
        for i in range(len(nums)):
            if lefts[i] > 1 and rights[i] > 1:
                res = min(res, len(nums) - (lefts[i] + rights[i] - 1))
        return res

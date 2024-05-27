class Solution:
    def specialArray(self, nums: list[int]) -> int:
        nums.sort()
        i = 0
        while i < len(nums):
            nums_left = len(nums) - i
            if nums_left == nums[i]:
                return nums[i]
            if i == 0 and nums_left < nums[i]:
                return nums_left
            if nums_left > nums[i - 1] and nums_left < nums[i]:
                return nums_left
            while i + 1 < len(nums) and nums[i + 1] == nums[i]:
                i += 1
            i += 1
        return -1

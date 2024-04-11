class Solution:
    def checkPossibility(self, nums: list[int]) -> bool:
        def check(index, last):
            for i in range(index, len(nums)):
                if nums[i] < last:
                    return False
                last = nums[i]
            return True

        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                if i == 0 or nums[i - 1] <= nums[i + 1]:
                    last = nums[i + 1]
                else:
                    last = nums[i]
                return check(i + 2, last)
        return True

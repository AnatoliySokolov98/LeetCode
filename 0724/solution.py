class Solution:
    def pivotIndex(self, nums: list[int]) -> int:
        total = sum(nums)
        left_total = 0
        right_total = total

        for i in range(len(nums)):
            right_total -= nums[i]
            if left_total == right_total:
                return i
            left_total += nums[i]
        return -1

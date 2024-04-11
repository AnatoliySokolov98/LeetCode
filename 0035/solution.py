class Solution:
    def searchInsert(self, nums: list[int], target: int) -> int:
        res = len(nums)
        left, right = 0, len(nums) - 1
        while left <= right:
            pivot = (left + right) // 2
            if nums[pivot] == target:
                return pivot
            if nums[pivot] > target:
                res = pivot
                right = pivot - 1
            else:
                left = pivot + 1
        return res

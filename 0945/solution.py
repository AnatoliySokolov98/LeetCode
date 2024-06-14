class Solution:
    def minIncrementForUnique(self, nums: list[int]) -> int:
        nums.sort()
        curr = nums[0]
        res = 0
        for num in nums:
            if num <= curr:
                res += curr - num
                curr += 1
            else:
                curr = num + 1
        return res

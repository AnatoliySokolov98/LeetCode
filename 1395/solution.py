class Solution:
    def numTeams(self, nums: list[int]) -> int:
        res = 0
        for i in range(len(nums)):
            left = 0
            right = 0
            for j in range(i):
                if nums[j] < nums[i]:
                    left += 1
            for j in range(i + 1, len(nums)):
                if nums[j] > nums[i]:
                    right += 1
            res += left * right
            res += (i - left) * (len(nums) - i - 1 - right)
        return res

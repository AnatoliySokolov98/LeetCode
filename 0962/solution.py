class Solution:
    def maxWidthRamp(self, nums: list[int]) -> int:
        stack = []
        for i in range(len(nums)):
            if not stack or nums[i] < nums[stack[-1]]:
                stack.append(i)
        res = 0
        for i in range(len(nums) - 1, -1, -1):
            while stack and nums[i] >= nums[stack[-1]]:
                res = max(res, i - stack[-1])
                stack.pop()
        return res

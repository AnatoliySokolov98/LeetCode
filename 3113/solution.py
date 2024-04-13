class Solution:
    def numberOfSubarrays(self, nums: list[int]) -> int:
        stack = []
        res = 0
        for num in nums:
            while stack and num > stack[-1][0]:
                stack.pop()
            if stack and num == stack[-1][0]:
                stack[-1][1] += 1
            else:
                stack.append([num, 1])
            res += stack[-1][1]
        return res

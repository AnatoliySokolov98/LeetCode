class Solution:
    def longestSubarray(self, nums: list[int]) -> int:
        val = -1
        res = 0
        curr = 0
        for num in nums:
            if num > val:
                val = num
                curr = 1
                res = 0
            elif num == val:
                curr += 1
            else:
                curr = 0
            res = max(res, curr)
        return res

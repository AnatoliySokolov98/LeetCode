class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        res = 0
        nums = set(nums)
        for num in nums:
            if num - 1 in nums:
                continue
            curr = 1
            while num + 1 in nums:
                num = num + 1
                curr += 1
            res = max(res, curr)
        return res

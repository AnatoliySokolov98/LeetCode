class Solution:
    def minPatches(self, nums: list[int], n: int) -> int:
        res = 0
        num = 0
        i = 0
        while num + 1 <= n:
            if i < len(nums) and nums[i] <= num + 1:
                num += nums[i]
                i += 1
            else:
                res += 1
                num += num + 1
        return res

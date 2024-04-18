class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        l = 0
        res = float("inf")
        curr = 0
        for r in range(len(nums)):
            curr += nums[r]
            while curr - nums[l] >= target:
                curr -= nums[l]
                l += 1
            if curr >= target:
                res = min(res, r - l + 1)
        return res if res != float("inf") else 0

class Solution:
    def maximumSubarraySum(self, nums: list[int], k: int) -> int:
        res = 0
        total = 0
        l = 0
        uniques = set()
        for r, v in enumerate(nums):
            total += nums[r]
            while v in uniques or r - l + 1 > k:
                uniques.remove(nums[l])
                total -= nums[l]
                l += 1
            uniques.add(v)
            if r - l + 1 == k:
                res = max(res, total)
        return res

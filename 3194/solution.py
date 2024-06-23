class Solution:
    def minimumAverage(self, nums: list[int]) -> float:
        nums.sort()
        l, r = 0, len(nums) - 1
        res = float("inf")
        while l < r:
            res = min(res, (nums[l] + nums[r]) / 2)
            l += 1
            r -= 1
        return res

        # O(nlogn)
        # O(1)

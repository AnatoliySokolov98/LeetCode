class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        res = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            target = 0 - nums[i]
            l, r = i + 1, len(nums) - 1
            while l < r:
                total = nums[l] + nums[r]
                if total < target:
                    l += 1
                elif total > target:
                    r -= 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    while l + 1 < len(nums) and nums[l + 1] == nums[l]:
                        l += 1
                    l += 1
        return res

class Solution:
    def minOperations(self, nums: list[int]) -> int:
        res = 0
        for i in range(len(nums) - 2):
            if nums[i] == 0:
                res += 1
                nums[i] = 1
                nums[i + 1] = 1 - nums[i + 1]
                nums[i + 2] = 1 - nums[i + 2]
        return res if nums[-1] == 1 and nums[-2] == 1 else -1

        # time O(n)
        # space O(1)

class Solution:
    def isArraySpecial(self, nums: list[int]) -> bool:
        N = len(nums)
        for i in range(N - 1):
            if nums[i] % 2 == nums[i + 1] % 2:
                return False
        return True

        # time O(n)
        # space O(1)

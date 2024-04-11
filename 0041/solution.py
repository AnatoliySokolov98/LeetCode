class Solution:
    def firstMissingPositive(self, nums: list[int]) -> int:
        BIG = 10**5 + 1
        N = len(nums)
        for i in range(len(nums)):
            if nums[i] < 0 or nums[i] > N:
                nums[i] = 0

        for i in range(len(nums)):
            loc = (nums[i] % BIG) - 1
            if 0 <= loc < N:
                nums[loc] = (nums[loc] % BIG) + BIG

        for i in range(len(nums)):
            if nums[i] < BIG:
                return i + 1
        return N + 1

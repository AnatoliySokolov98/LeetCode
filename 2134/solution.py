class Solution:
    def minSwaps(self, nums: list[int]) -> int:
        N = len(nums)
        ones = 0
        for num in nums:
            ones += num == 1
        res = float("inf")
        zeroes = 0
        for r in range(N + ones):
            zeroes += nums[r % N] == 0
            if r >= ones:
                zeroes -= nums[r - ones] == 0
            if r >= ones - 1:
                res = min(res, zeroes)
        return res

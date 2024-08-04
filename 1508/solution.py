class Solution:
    def rangeSum(self, nums: list[int], n: int, left: int, right: int) -> int:
        sums = []
        for i in range(len(nums)):
            total = 0
            for j in range(i, len(nums)):
                total += nums[j]
                sums.append(total)
        sums.sort()
        return sum(sums[left - 1 : right]) % (10**9 + 7)

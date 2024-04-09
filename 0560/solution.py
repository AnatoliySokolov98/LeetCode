from collections import defaultdict


class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        prefix_sums = defaultdict(int)
        total = 0
        res = 0
        prefix_sums[0] = 1
        for num in nums:
            total += num
            res += prefix_sums[total - k]
            prefix_sums[total] += 1
        return res

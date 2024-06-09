from collections import defaultdict


class Solution:
    def subarraysDivByK(self, nums: list[int], k: int) -> int:
        counts = defaultdict(int)
        total = 0
        counts[0] = 1
        res = 0
        for num in nums:
            total += num
            res += counts[total % k]
            counts[total % k] += 1
        return res

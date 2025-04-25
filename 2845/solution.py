from collections import defaultdict


class Solution:
    def countInterestingSubarrays(self, nums: list[int], modulo: int, k: int) -> int:
        prefix_sums = defaultdict(int)
        prefix_sums[0] = 1
        res = 0
        total = 0
        for num in nums:
            total += num % modulo == k
            target = (total - k + modulo) % modulo
            res += prefix_sums[target]
            prefix_sums[total % modulo] += 1
        return res
        #time O(N)
        #space O(N)
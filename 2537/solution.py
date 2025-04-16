from collections import defaultdict


class Solution:
    def countGood(self, nums: list[int], k: int) -> int:
        counts = defaultdict(int)
        res = 0
        l = 0
        pairs = 0
        for r in range(len(nums)):
            pairs += counts[nums[r]]
            counts[nums[r]] += 1
            while pairs >= k:
                if pairs - (counts[nums[l]] - 1) >= k:
                    pairs -= (counts[nums[l]] - 1)
                    counts[nums[l]] -= 1
                    l += 1
                else:
                    break
            if pairs >= k :
                res += l + 1
        return res
              
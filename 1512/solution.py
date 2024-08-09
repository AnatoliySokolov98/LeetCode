class Solution:
    def numIdenticalPairs(self, nums: list[int]) -> int:
        res = 0
        counts = {}
        for num in nums:
            if num in counts:
                res += counts[num]
                counts[num] += 1
            else:
                counts[num] = 1
        return res

        # time O(n)
        # space O(n)

class Solution:
    def minOperations(self, nums: list[int]) -> int:
        res = 0
        flipped = False
        for num in nums:
            if flipped - num == 0:
                res += 1
                flipped = not flipped
        return res

        # time O(n)
        # space O(1)

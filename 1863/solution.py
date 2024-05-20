class Solution:
    def subsetXORSum(self, nums: list[int]) -> int:
        res = 0
        curr = 0

        def backtrack(i):
            nonlocal res, curr
            if i == len(nums):
                res += curr
                return
            curr ^= nums[i]
            backtrack(i + 1)
            curr ^= nums[i]
            backtrack(i + 1)

        backtrack(0)
        return res

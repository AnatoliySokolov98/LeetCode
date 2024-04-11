class Solution:
    def sortedSquares(self, nums: list[int]) -> list[int]:
        l, r = 0, len(nums) - 1
        res = []
        while l < r:
            if abs(nums[l]) < abs(nums[r]):
                res.append(nums[r] ** 2)
                r -= 1
            else:
                res.append(nums[l] ** 2)
                l += 1

        res.append(nums[l] ** 2)
        return res[::-1]
        # time O(n)
        # space O(1)

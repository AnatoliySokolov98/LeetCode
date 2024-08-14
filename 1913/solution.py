class Solution:
    def maxProductDifference(self, nums: list[int]) -> int:
        a, b, c, d = sorted(nums[:4])
        for i in range(4, len(nums)):
            if nums[i] < b:
                if nums[i] < a:
                    a, b = nums[i], a
                else:
                    b = nums[i]
            elif nums[i] > c:
                if nums[i] > d:
                    c, d = d, nums[i]
                else:
                    c = nums[i]
        return d * c - a * b
        # time O(n)
        # space O(1)

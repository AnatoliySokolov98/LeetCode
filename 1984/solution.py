class Solution:
    def minimumDifference(self, nums: list[int], k: int) -> int:
        nums.sort()
        res = float("inf")
        left, right = 0, k - 1
        while right < len(nums):
            res = min(res, (nums[right] - nums[left]))
            left += 1
            right += 1
        return res

        # time O(n)
        # space O(1)

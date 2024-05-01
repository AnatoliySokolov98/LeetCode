class Solution:
    def maxFrequency(self, nums: list[int], k: int) -> int:
        nums.sort()
        left = 0
        res = 1
        cost = 0
        for right in range(1, len(nums)):
            cost += (nums[right] - nums[right - 1]) * (right - left)
            while cost > k:
                cost -= nums[right] - nums[left]
                left += 1
            res = max(right - left + 1, res)
        return res

        # time O(nlogn)
        # space O(1)

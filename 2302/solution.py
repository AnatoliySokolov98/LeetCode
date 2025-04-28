class Solution:
    def countSubarrays(self, nums: list[int], k: int) -> int:
        res = l = total = 0
        for r, v in enumerate(nums):
            total += v
            while l <= r and total * (r - l + 1) >= k:
                total -= nums[l]
                l += 1
            res += r - l + 1
        return res

        #time O(n)
        #space O(1)
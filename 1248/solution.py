class Solution:
    def numberOfSubarrays(self, nums: list[int], k: int) -> int:
        l = 0
        mid = 0
        odds = 0
        res = 0
        for r in range(len(nums)):
            odds += nums[r] % 2
            if odds > k:
                mid += 1
                l = mid
                odds -= 1

            while odds == k and nums[mid] % 2 == 0:
                mid += 1

            if odds == k:
                res += mid - l + 1
        return res

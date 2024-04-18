class Solution:
    def numSubseq(self, nums: list[int], target: int) -> int:
        nums.sort()
        l = 0
        r = len(nums) - 1
        MOD = 10**9 + 7
        res = 0
        while l <= r:
            if nums[l] + nums[r] > target:
                r -= 1
            else:
                res = (res + pow(2, r - l, MOD)) % MOD
                l += 1
        return res

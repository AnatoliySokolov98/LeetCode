class Solution:
    def minCapability(self, nums: list[int], k: int) -> int:
        l, r = 0, max(nums)

        def canRob(num):
            count = 0
            i = 0
            while i < len(nums):
                if nums[i] <= num:
                    count += 1
                    i += 1
                i += 1
            return count >= k

        res = r
        while l <= r:
            p = (l + r) // 2
            if canRob(p):
                res = p
                r = p - 1
            else:
                l = p + 1
        return res

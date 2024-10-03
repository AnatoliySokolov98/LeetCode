class Solution:
    def minSubarray(self, nums: list[int], p: int) -> int:
        total = sum(nums) % p
        if total == 0:
            return 0

        locs = {0: -1}
        curr = 0
        res = float("inf")

        for i, v in enumerate(nums):
            curr += v
            mod = curr % p
            target = (mod - total) % p

            if target in locs:
                res = min(res, i - locs[target])

            locs[mod] = i

        return res if res < len(nums) else -1

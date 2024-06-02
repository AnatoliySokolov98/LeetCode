class Solution:
    def minimumDifference(self, nums: list[int], k: int) -> int:
        bits = [0 for _ in range(32)]
        res = float("inf")
        l = 0
        curr = 0
        for r in range(len(nums)):
            num = nums[r]
            j = 0
            while num > 0:
                if num & 1:
                    bits[j] += 1
                num >>= 1
                j += 1
            curr = 0
            for i in range(len(bits)):
                if bits[i] == r - l + 1:
                    curr += 2**i
            while curr <= k and l <= r:
                res = min(res, abs(k - curr))
                num = nums[l]
                j = 0
                while num > 0:
                    if num & 1:
                        bits[j] -= 1
                    num >>= 1
                    j += 1
                l += 1
                curr = 0
                for i in range(len(bits)):
                    if bits[i] == r - l + 1:
                        curr += 2**i
            res = min(res, abs(k - curr))
        return res
        # time O(n)
        # space O(1)

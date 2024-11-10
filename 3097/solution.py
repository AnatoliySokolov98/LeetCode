class Solution:
    def minimumSubarrayLength(self, nums: list[int], k: int) -> int:
        bits = [0] * 32
        res = float("inf")
        left = 0

        def addBits(num):
            i = 0
            while num:
                bits[i] += num & 1
                num >>= 1
                i += 1

        def subtractBits(num):
            i = 0
            while num:
                bits[i] -= num & 1
                num >>= 1
                i += 1

        def currentBitSum():
            result = 0
            for i in range(32):
                if bits[i] > 0:
                    result |= 1 << i
            return result

        for right in range(len(nums)):
            addBits(nums[right])

            while currentBitSum() >= k and left <= right:
                res = min(res, right - left + 1)
                subtractBits(nums[left])
                left += 1

        return res if res != float("inf") else -1

class Solution:
    def numberOfPairs(self, nums1: list[int], nums2: list[int], k: int) -> int:
        res = 0
        for num in nums1:
            for num2 in nums2:
                if num % (num2 * k) == 0:
                    res += 1
        return res
        # time O(N^2)
        # space O(1)

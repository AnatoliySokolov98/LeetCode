class Solution:
    def largestCombination(self, candidates: list[int]) -> int:
        nums = [0] * 32
        for num in candidates:
            i = 0
            while num:
                if num & 1:
                    nums[i] += 1
                num >>= 1
                i += 1
        return max(nums)

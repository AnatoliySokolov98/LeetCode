class Solution:
    def minimumOperations(self, nums: list[int], target: list[int]) -> int:
        res = 0
        curr = 0
        pos = True
        for i in range(len(nums)):
            diff = abs(target[i] - nums[i])
            sign = target[i] >= nums[i]
            if pos != sign:
                res += curr
            elif diff < curr:
                res += curr - diff
            curr, pos = diff, sign
        return res + curr

        # time O(n)
        # space O(1)

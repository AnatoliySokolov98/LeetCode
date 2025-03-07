from math import ceil, sqrt


class Solution:
    def closestPrimes(self, left: int, right: int) -> list[int]:
        nums = [True] * (right + 1)
        nums[0] = nums[1] = False
        for i in range(2, ceil(sqrt(right)) + 1):
            if nums[i]:
                for j in range(i * i, right + 1, i):
                    nums[j] = False
        res = [float("-inf"), float("inf")]
        last_number = None
        for i in range(left, right + 1):
            if nums[i]:
                if last_number and i - last_number < res[1] - res[0]:
                    res = [last_number, i]
                last_number = i
        return res if res[0] != float("-inf") else [-1, -1]
        # time O(nlog^2(n))
        # space O(n)

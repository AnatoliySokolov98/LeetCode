from math import ceil
from functools import cache


class Solution:
    def maximumPrimeDifference(self, nums: list[int]) -> int:
        @cache
        def is_prime(num):
            for i in range(2, ceil(num**0.5) + 1):
                if num % i == 0 and num // i > 1:
                    return False
            return num != 1

        left = None
        right = None
        for i in range(len(nums)):
            if is_prime(nums[i]):
                if left == None:
                    left = i
                right = i
        return right - left

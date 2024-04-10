from functools import cmp_to_key


class Solution:
    def largestNumber(self, nums: list[int]) -> str:
        nums = list(map(str, nums))

        def custom_comparator(a, b):
            if a + b > b + a:
                return -1
            else:
                return 1

        nums.sort(key=cmp_to_key(custom_comparator))

        return str(int("".join(nums)))

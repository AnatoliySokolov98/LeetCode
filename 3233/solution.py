from math import sqrt


class Solution:
    def nonSpecialCount(self, l: int, r: int) -> int:
        limit = int(sqrt(r))
        nums = [True] * (limit + 1)
        nums[0] = False
        nums[1] = False
        for i in range(2, len(nums)):
            if nums[i] == True:
                for j in range(i * i, limit + 1, i):
                    nums[j] = False
        return (
            r
            - l
            + 1
            - sum(1 for i, v in enumerate(nums) if v == True and l <= i**2 <= r)
        )

        # time O(srqt(n) log(sqrtn))
        # space O(srqt(n))

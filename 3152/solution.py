from collections import defaultdict


class Solution:
    def isArraySpecial(self, nums: list[int], queries: list[list[int]]) -> list[bool]:
        count = defaultdict(int)
        count[-1] = 0
        count[0] = 0
        for i in range(1, len(nums)):
            if (nums[i] % 2) == (nums[i - 1] % 2):
                count[i] = count[i - 1] + 1
            else:
                count[i] = count[i - 1]
        res = []
        for x, y in queries:
            if x == y:
                res.append(True)
            else:
                res.append(count[x] == count[y])
        return res

        # time O(n + q)
        # space O(n)

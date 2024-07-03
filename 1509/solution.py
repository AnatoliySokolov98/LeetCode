from heapq import heappop, heappush


class Solution:
    def minDifference(self, nums: list[int]) -> int:
        if len(nums) <= 4:
            return 0
        small = []
        big = []
        res = float("inf")
        for num in nums:
            heappush(small, num)
            if len(small) > 4:
                heappop(small)
            heappush(big, -num)
            if len(big) > 4:
                heappop(big)
        small.sort()
        big = sorted([-num for num in big])
        for i in range(4):
            for j in range(4 - i):
                res = min(res, small[len(small) - 1 - j] - big[i])
        return res

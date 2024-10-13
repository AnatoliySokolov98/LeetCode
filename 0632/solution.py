from heapq import heappop, heappush


class Solution:
    def smallestRange(self, nums: list[list[int]]) -> list[int]:
        range_min = float("-inf")
        range_max = float("inf")
        curr_max = float("-inf")
        heap = []
        for i in range(len(nums)):
            heappush(heap, [nums[i][0], i, 0])
            curr_max = max(curr_max, nums[i][0])
        while len(heap) == len(nums):
            val, i, j = heappop(heap)
            if curr_max - val < range_max - range_min:
                range_max, range_min = curr_max, val
            if j + 1 < len(nums[i]):
                curr_max = max(curr_max, nums[i][j + 1])
                heappush(heap, [nums[i][j + 1], i, j + 1])
        return [range_min, range_max]

from heapq import heappush, heappop
from collections import Counter


class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        heap = []
        count = Counter(nums)
        for i in set(nums):
            heappush(heap, (-1 * count[i], i))
        return [heappop(heap)[1] for _ in range(k)]

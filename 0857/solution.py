from heapq import heappop, heappush


class Solution:
    def mincostToHireWorkers(
        self, quality: list[int], wage: list[int], k: int
    ) -> float:
        L = len(wage)
        pairs = sorted((wage[i] / quality[i], quality[i]) for i in range(L))
        heap = []
        res = float("inf")
        total = 0
        for ratio, qual in pairs:
            heappush(heap, -qual)
            total += qual
            if len(heap) > k:
                qual_gone = heappop(heap)
                total += qual_gone
            if len(heap) == k:
                res = min(res, total * ratio)
        return res

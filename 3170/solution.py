from heapq import heappop, heappush


class Solution:
    def clearStars(self, s: str) -> str:
        heap = []
        for i, v in enumerate(s):
            if v == "*":
                heappop(heap)
            else:
                heappush(heap, [v, -i])
        heap.sort(key=lambda x: -x[1])
        return "".join([item[0] for item in heap])
        # time O(nlogn)
        # space O(n)

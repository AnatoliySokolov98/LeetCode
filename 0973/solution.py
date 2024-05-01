from heapq import heapify, heappop


class Solution:
    def kClosest(self, points: list[list[int]], k: int) -> list[list[int]]:
        for point in points:
            point.insert(0, point[0] ** 2 + point[1] ** 2)
        heapify(points)
        res = []
        while k > 0:
            temp = heappop(points)
            res.append([temp[1], temp[2]])
            k -= 1
        return res

        # time O(klogn)
        # space O(n)

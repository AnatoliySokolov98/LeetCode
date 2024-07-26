from collections import defaultdict
from heapq import heappop, heappush


class Solution:
    def findTheCity(
        self, n: int, edges: list[list[int]], distanceThreshold: int
    ) -> int:
        res = [1, float("inf")]
        graph = defaultdict(list)
        for x, y, dist in edges:
            graph[x].append([y, dist])
            graph[y].append([x, dist])
        for i in range(n):
            visited = set()
            heap = [[0, i]]
            while heap:
                dist, city = heappop(heap)
                if city in visited:
                    continue
                visited.add(city)
                for child, d in graph[city]:
                    if child not in visited and dist + d <= distanceThreshold:
                        heappush(heap, [dist + d, child])
            if len(visited) - 1 <= res[1]:
                res = [i, len(visited) - 1]
        return res[0]

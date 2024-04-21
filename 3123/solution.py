from collections import defaultdict
from heapq import heappop, heappush


class Solution:
    def findAnswer(self, n: int, edges: list[list[int]]) -> list[bool]:
        graph = defaultdict(dict)
        for x, y, w in edges:
            graph[x][y] = w
            graph[y][x] = w

        from_zero = defaultdict(int)
        from_last = defaultdict(int)
        res = [False] * len(edges)

        def djikstra(node, distances):
            heap = [[0, node]]
            visited = set()
            while heap:
                dist, curr = heappop(heap)
                if curr in visited:
                    continue
                visited.add(curr)
                distances[curr] = dist
                if curr not in graph:
                    continue
                for child in graph[curr]:
                    if child in visited:
                        continue
                    heappush(heap, [dist + graph[curr][child], child])

        djikstra(0, from_zero)
        if n - 1 not in from_zero:
            return res
        djikstra(n - 1, from_last)

        for i, (x, y, w) in enumerate(edges):
            if x not in from_zero or y not in from_zero:
                continue
            if (
                from_zero[x] + w + from_last[y] == from_zero[n - 1]
                or from_zero[y] + w + from_last[x] == from_zero[n - 1]
            ):
                res[i] = True
        return res

from heapq import heappush, heappop


class Solution:
    def minimumTime(
        self, n: int, edges: list[list[int]], disappear: list[int]
    ) -> list[int]:
        graph = {}
        for x, y, time in edges:
            if x not in graph:
                graph[x] = {}
            if y not in graph:
                graph[y] = {}
            graph[x][y] = min(graph[x].get(y, float("inf")), time)
            graph[y][x] = min(graph[y].get(x, float("inf")), time)
        res = [-1] * n
        heap = [(0, 0)]
        visited = set()
        while heap:
            time, node = heappop(heap)
            if node in visited:
                continue
            res[node] = time
            visited.add(node)
            if node in graph:
                for child in graph[node]:
                    if (
                        child not in visited
                        and graph[node][child] + time < disappear[child]
                    ):
                        heappush(heap, (graph[node][child] + time, child))
        return res

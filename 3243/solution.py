from collections import deque


class Solution:
    def shortestDistanceAfterQueries(
        self, n: int, queries: list[list[int]]
    ) -> list[int]:
        graph = {i: [i + 1] for i in range(n)}
        res = []
        for [x, y] in queries:
            graph[x].append(y)
            bfs = deque()
            bfs.append([0, 0])
            visited = set()
            visited.add(0)
            while bfs:
                dist, node = bfs.popleft()
                if node == n - 1:
                    res.append(dist)
                    break
                for child in graph[node]:
                    if child not in visited:
                        visited.add(child)
                        bfs.append([dist + 1, child])
        return res

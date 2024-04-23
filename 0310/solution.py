from collections import defaultdict


class Solution:
    def findMinHeightTrees(self, n: int, edges: list[list[int]]) -> list[int]:
        if n == 1:
            return [0]
        indegrees = [0] * n
        graph = defaultdict(list)
        for x, y in edges:
            graph[x].append(y)
            graph[y].append(x)
            indegrees[x] += 1
            indegrees[y] += 1
        curr_level = []
        next_level = []

        for i, v in enumerate(indegrees):
            if v == 1:
                curr_level.append(i)
        while True:
            for node in curr_level:
                for child in graph[node]:
                    indegrees[child] -= 1
                    if indegrees[child] == 1:
                        next_level.append(child)
            if not next_level:
                return curr_level
            curr_level = next_level
            next_level = []
        return []

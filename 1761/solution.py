from collections import defaultdict


class Solution:
    def minTrioDegree(self, n: int, edges: list[list[int]]) -> int:
        graph = defaultdict(set)
        for x,y in edges:
            graph[x].add(y)
            graph[y].add(x)
        res = float('inf')
        for i in range(1,n + 1):
            for j in range(i + 1, n + 1):
                for k in range(j + 1, n + 1):
                    if j in graph[i] and k in graph[i] and k in graph[j]:
                        res = min(res, len(graph[i]) + len(graph[j]) + len(graph[k]) - 6)
        return res if res != float('inf') else -1
        #time O(n^3)
        #space O(n^2)
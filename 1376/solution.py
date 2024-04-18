from collections import defaultdict


class Solution:
    def numOfMinutes(
        self, n: int, headID: int, manager: list[int], informTime: list[int]
    ) -> int:
        edges = defaultdict(list)
        for index, value in enumerate(manager):
            edges[value].append(index)

        def dfs(node):
            if not edges[node]:
                return 0
            res = 0
            for edge in edges[node]:
                res = max(res, dfs(edge))
            return informTime[node] + res

        return dfs(headID)

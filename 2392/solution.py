class Solution:
    def buildMatrix(
        self, k: int, rowConditions: list[list[int]], colConditions: list[list[int]]
    ) -> list[list[int]]:
        # Initialize graphs and indegree arrays for rows and columns
        rowGraph = {i: [] for i in range(1, k + 1)}
        colGraph = {i: [] for i in range(1, k + 1)}
        rowIndegrees = [0] * k
        colIndegrees = [0] * k

        # Fill in the graphs and indegree arrays based on conditions
        for x, y in rowConditions:
            rowGraph[x].append(y)
            rowIndegrees[y - 1] += 1

        for x, y in colConditions:
            colGraph[x].append(y)
            colIndegrees[y - 1] += 1

        def topological_sort(graph: dict, indegrees: list[int]) -> list[int]:
            bfs = [i + 1 for i in range(len(indegrees)) if indegrees[i] == 0]
            order = []

            while bfs:
                node = bfs.pop()
                order.append(node)
                for child in graph[node]:
                    indegrees[child - 1] -= 1
                    if indegrees[child - 1] == 0:
                        bfs.append(child)

            if len(order) != k:
                return []

            return order

        # Perform topological sort for rows
        rowOrder = topological_sort(rowGraph, rowIndegrees)
        if not rowOrder:
            return []

        # Perform topological sort for columns
        colOrder = topological_sort(colGraph, colIndegrees)
        if not colOrder:
            return []

        # Construct the matrix based on row and column orders
        res = [[0 for _ in range(k)] for _ in range(k)]
        col_locs = {colOrder[i]: i for i in range(len(colOrder))}
        for i, v in enumerate(rowOrder):
            res[i][col_locs[v]] = v
        return res

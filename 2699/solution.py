from collections import defaultdict
from heapq import heappop, heappush


class Solution:

    def modifiedGraphEdges(
        self, n: int, edges: list[list[int]], source: int, destination: int, target: int
    ) -> list[list[int]]:
        paths = defaultdict(dict)
        neg_edges = defaultdict(set)
        for left, right, weight in edges:
            if weight == -1:
                neg_edges[left].add(right)
                neg_edges[right].add(left)
                weight = 1

            paths[left][right] = weight
            paths[right][left] = weight

        heap = [(0, 0, [source])]
        best_path = None
        best_path_length = 0

        while heap:
            negs, weight, path = heappop(heap)
            if path[-1] == destination:
                if negs > 0 or weight == target:
                    best_path = path
                    best_path_length = weight
                break

            node = path[-1]
            for new_node in paths[node]:
                if new_node in path:
                    continue
                new_negs = 1 + negs if new_node in neg_edges[node] else negs
                new_weight = weight + paths[node][new_node]
                new_path = path + [new_node]
                if new_weight <= target:
                    heappush(heap, (new_negs, new_weight, new_path))
        if not best_path:
            return []

        addition = target - best_path_length

        path_nodes = set()
        for i in range(len(best_path) - 1):
            path_nodes.add((best_path[i], best_path[i + 1]))
            path_nodes.add((best_path[i + 1], best_path[i]))
        res = []
        for left, right, weight in edges:
            if weight >= 1:
                res.append([left, right, weight])
            elif (left, right) in path_nodes:
                res.append([left, right, 1 + addition])
                addition = 0
            else:
                res.append([left, right, 2 * (10**9)])
        return res

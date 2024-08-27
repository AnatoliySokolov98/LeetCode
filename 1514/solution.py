from collections import defaultdict
from heapq import heappop, heappush


class Solution:
    def maxProbability(
        self,
        n: int,
        edges: list[list[int]],
        succProb: list[float],
        start: int,
        end: int,
    ) -> float:
        paths = defaultdict(list)
        for i in range(len(edges)):
            first, second = edges[i]
            paths[first].append([second, succProb[i]])
            paths[second].append([first, succProb[i]])
        heap = [[-1, start]]
        visited = {start}

        while heap:
            node_prob, node = heappop(heap)
            if node == end:
                return -node_prob
            visited.add(node)
            for path, prob in paths[node]:
                if path not in visited:
                    heappush(heap, [node_prob * prob, path])
        return 0

        # time O(E+ ElogE)
        # space O(E + V)

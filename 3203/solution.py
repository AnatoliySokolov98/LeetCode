from collections import defaultdict, deque
from math import ceil


class Solution:
    def minimumDiameterAfterMerge(
        self, edges1: list[list[int]], edges2: list[list[int]]
    ) -> int:
        graph1 = defaultdict(list)
        for x, y in edges1:
            graph1[x].append(y)
            graph1[y].append(x)
        bfs = deque([0])
        visited = set()
        visited.add(0)
        while bfs:
            leaf1 = bfs.popleft()
            for child in graph1[leaf1]:
                if child not in visited:
                    visited.add(child)
                    bfs.append(child)
        bfs = deque()
        bfs.append([leaf1, 0])
        visited = set()
        visited.add(leaf1)
        dist1 = 0
        while bfs:
            node, dist = bfs.popleft()
            dist1 = max(dist1, dist)
            for child in graph1[node]:
                if child not in visited:
                    visited.add(child)
                    bfs.append([child, dist + 1])
        graph2 = defaultdict(list)
        for x, y in edges2:
            graph2[x].append(y)
            graph2[y].append(x)
        bfs = deque([0])
        visited = set()
        visited.add(0)
        while bfs:
            leaf2 = bfs.popleft()
            for child in graph2[leaf2]:
                if child not in visited:
                    visited.add(child)
                    bfs.append(child)
        bfs = deque()
        bfs.append([leaf2, 0])
        visited = set()
        visited.add(leaf2)
        dist2 = 0
        while bfs:
            node, dist = bfs.popleft()
            dist2 = max(dist2, dist)
            for child in graph2[node]:
                if child not in visited:
                    visited.add(child)
                    bfs.append([child, dist + 1])
        return max(dist1, dist2, ceil(dist1 / 2) + ceil(dist2 / 2) + 1)

        # time O(E1 + E2)
        # space O(max(E1, E2))

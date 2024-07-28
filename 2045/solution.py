from collections import deque


class Solution:
    def secondMinimum(
        self, n: int, edges: list[list[int]], time: int, change: int
    ) -> int:
        graph = [[] for _ in range(n + 1)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        dist = [[float("inf"), float("inf")] for _ in range(n + 1)]
        dist[1][1] = 0

        queue = deque([(1, 0)])
        while queue:
            node, current_time = queue.popleft()
            next_time = current_time + time
            cycle = current_time // change

            if cycle % 2 == 1:
                wait_time = change - (current_time % change)
                next_time += wait_time

            for neighbor in graph[node]:
                if next_time < dist[neighbor][0]:
                    dist[neighbor][0] = next_time
                    queue.append((neighbor, next_time))
                elif dist[neighbor][0] < next_time < dist[neighbor][1]:
                    dist[neighbor][1] = next_time
                    queue.append((neighbor, next_time))

        return dist[n][1]

class Solution:
    def minimumCost(
        self,
        source: str,
        target: str,
        original: list[str],
        changed: list[str],
        cost: list[int],
    ) -> int:
        T = len(target)
        O = len(original)
        graph = [[float("inf") for _ in range(26)] for _ in range(26)]
        for i in range(O):
            x = ord(original[i]) - ord("a")
            y = ord(changed[i]) - ord("a")
            graph[x][y] = min(graph[x][y], cost[i])

        for i in range(26):
            graph[i][i] = 0

        for k in range(26):
            for i in range(26):
                for j in range(26):
                    if graph[i][k] + graph[k][j] < graph[i][j]:
                        graph[i][j] = graph[i][k] + graph[k][j]
        res = 0
        for i in range(T):
            x = ord(source[i]) - ord("a")
            y = ord(target[i]) - ord("a")
            if graph[x][y] == float("inf"):
                return -1
            res += graph[x][y]
        return res

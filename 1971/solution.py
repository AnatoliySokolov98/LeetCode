from collections import defaultdict


class Solution:
    def validPath(
        self, n: int, edges: list[list[int]], source: int, destination: int
    ) -> bool:
        if source == destination:
            return True
        numbers = defaultdict(list)
        for src, dst in edges:
            numbers[src].append(dst)
            numbers[dst].append(src)
        visited_nodes = set([source])
        nodes = deque([source])
        while nodes:
            curr = nodes.popleft()
            for child in numbers[curr]:
                if child in visited_nodes:
                    continue
                visited_nodes.add(child)
                nodes.append(child)
                if child == destination:
                    return True
        return False

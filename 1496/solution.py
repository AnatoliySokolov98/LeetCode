class Solution:
    def isPathCrossing(self, path: str) -> bool:
        dirs = {"N": [0, 1], "S": [0, -1], "E": [1, 0], "W": [-1, 0]}

        visited = set()
        visited.add((0, 0))
        x = 0
        y = 0
        for char in path:
            x += dirs[char][0]
            y += dirs[char][1]
            if (x, y) in visited:
                return True
            visited.add((x, y))
        return False
        # time O(N)
        # space O(N)

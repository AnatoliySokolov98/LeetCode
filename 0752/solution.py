from collections import deque


class Solution:
    def openLock(self, deadends: list[str], target: str) -> int:
        if target == "0000":
            return 0

        def lock_converter(choice):
            a = set()
            b = set()
            c = a
            res = []
            nums = [-1, 1]
            for i in range(len(choice)):
                for num in nums:
                    out = (int(choice[i]) + num) % 10
                    res.append(choice[:i] + str(out) + choice[i + 1 :])
            return res

        bfs = deque()
        visited = set(deadends)
        if ("0000") in visited:
            return -1
        bfs.append(["0000", 0])
        visited.add("0000")
        while bfs:
            key, moves = bfs.popleft()
            if key == target:
                return moves
            children = lock_converter(key)
            for child in children:
                if child not in visited:
                    visited.add(child)
                    bfs.append([child, moves + 1])

        return -1

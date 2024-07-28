from math import sqrt


class UnionFind:
    def __init__(self, n: int):
        self.roots = [i for i in range(n)]
        self.ranks = [1] * n
        self.paths = [[False for _ in range(4)] for _ in range(n)]

    def find(self, x: int) -> int:
        if self.roots[x] != x:
            self.roots[x] = self.find(self.roots[x])
        return self.roots[x]

    def union(self, x: int, y: int) -> bool:
        X = self.find(x)
        Y = self.find(y)

        if X == Y:
            return False

        if self.ranks[X] > self.ranks[Y]:
            self.roots[Y] = X
            for i in range(4):
                self.paths[X][i] = self.paths[X][i] or self.paths[Y][i]
        elif self.ranks[Y] > self.ranks[X]:
            self.roots[X] = Y
            for i in range(4):
                self.paths[Y][i] = self.paths[Y][i] or self.paths[X][i]
        else:
            self.roots[Y] = X
            self.ranks[X] += 1
            for i in range(4):
                self.paths[X][i] = self.paths[X][i] or self.paths[Y][i]
        return True


class Solution:
    def canReachCorner(self, X: int, Y: int, circles: list[list[int]]) -> bool:
        C = len(circles)
        uf = UnionFind(C)
        for i in range(C):
            x, y, r = circles[i]
            if x - r <= 0:  # touches left boundary
                uf.paths[i][0] = True
            if x + r >= X:  # touches right boundary
                uf.paths[i][1] = True
            if y + r >= Y:  # touches top boundary
                uf.paths[i][2] = True
            if y - r <= 0:  # touches bottom boundary
                uf.paths[i][3] = True

        for i in range(len(circles)):
            for j in range(i + 1, len(circles)):
                x1, y1, r1 = circles[i]
                x2, y2, r2 = circles[j]
                dist = sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
                if dist <= r1 + r2:
                    uf.union(i, j)
        for vals in uf.paths:
            if (
                (vals[0] and vals[3])
                or (vals[1] and vals[2])
                or (vals[0] and vals[1])
                or (vals[2] and vals[3])
            ):
                return False
        return True

        # time O(c^2)
        # space O(c)

from collections import defaultdict


class UnionFind:
    def __init__(self, n):
        self.rank = [1] * n
        self.parent = [i for i in range(n)]
        self.size = [1] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        X = self.find(x)
        Y = self.find(y)
        if X == Y:
            return
        if self.rank[X] < self.rank[Y]:
            self.parent[X] = Y
            self.size[Y] += self.size[X]
        elif self.rank[X] > self.rank[Y]:
            self.parent[Y] = X
            self.size[X] += self.size[Y]
        else:
            self.parent[Y] = X
            self.rank[X] = self.rank[X] + 1
            self.size[X] += self.size[Y]


class Solution:
    def removeStones(self, stones: list[list[int]]) -> int:
        N = len(stones)
        uf = UnionFind(N)
        rows = defaultdict(int)
        cols = defaultdict(int)
        for i, (r, c) in enumerate(stones):
            if r in rows:
                uf.union(rows[r], i)
            rows[r] = i
            if c in cols:
                uf.union(cols[c], i)
            cols[c] = i
        res = 0
        for i in range(N):
            if uf.find(i) == i:
                res += uf.size[i] - 1
        return res

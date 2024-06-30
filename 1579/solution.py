class UnionFind:
    def __init__(self, n):
        self.roots = [i for i in range(n)]
        self.ranks = [1] * n
        self.components = n

    def find(self, x):
        if self.roots[x] != x:
            self.roots[x] = self.find(self.roots[x])
        return self.roots[x]

    def union(self, x, y):
        X = self.find(x)
        Y = self.find(y)
        if X == Y:
            return False
        if self.ranks[Y] > self.ranks[X]:
            self.roots[X] = Y
        elif self.ranks[X] > self.ranks[Y]:
            self.roots[Y] = X
        else:
            self.roots[Y] = X
            self.ranks[Y] += 1
        self.components -= 1
        return True


class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: list[list[int]]) -> int:
        res = 0
        alice = UnionFind(n)
        bob = UnionFind(n)
        for t, x, y in edges:
            x -= 1
            y -= 1
            if t == 3:
                a = alice.union(x, y)
                b = bob.union(x, y)
                if not (a and b):
                    res += 1
        for t, x, y in edges:
            x -= 1
            y -= 1
            if t == 1 and not alice.union(x, y):
                res += 1
            if t == 2 and not bob.union(x, y):
                res += 1
        print(alice.components, bob.components)
        return res if alice.components == 1 and bob.components == 1 else -1

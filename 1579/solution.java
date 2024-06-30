class UnionFind {
    private int[] roots;
    private int[] ranks;
    int components;

    public UnionFind(int n) {
        roots = new int[n];
        ranks = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            ranks[i] = 1;
        }
        components = n;
    }

    private int find(int x) {
        if (roots[x] != x) {
            roots[x] = find(roots[x]);
        }
        return roots[x];
    }

    public boolean union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if (X == Y) {
            return false;
        }
        if (ranks[X] > ranks[Y]) {
            roots[Y] = X;
        } else if (ranks[Y] > ranks[X]) {
            roots[X] = Y;
        } else {
            roots[X] = Y;
            ranks[Y]++;
        }
        components--;
        return true;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int res = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean a = alice.union(edge[1] - 1, edge[2] - 1);
                boolean b = bob.union(edge[1] - 1, edge[2] - 1);
                if (!a && !b) {
                    res++;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                boolean a = alice.union(edge[1] - 1, edge[2] - 1);
                if (!a) {
                    res++;
                }
            }
            if (edge[0] == 2) {
                boolean b = bob.union(edge[1] - 1, edge[2] - 1);
                if (!b) {
                    res++;
                }
            }
        }
        return (alice.components == 1 && bob.components == 1) ? res : -1;
    }
}

// time O(V + E)
// space O(V)
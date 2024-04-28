from collections import defaultdict


class Solution:
    def sumOfDistancesInTree(self, n: int, edges: list[list[int]]) -> list[int]:
        tree = defaultdict(list)
        count = [1] * n
        res = [0] * n
        for x, y in edges:
            tree[x].append(y)
            tree[y].append(x)

        def get_counts(root, pre):
            res = 0
            for i in tree[root]:
                if i != pre:
                    res += get_counts(i, root) + count[i]
                    count[root] += count[i]
            return res

        def traverse(root, pre):
            for i in tree[root]:
                if i != pre:
                    res[i] = res[root] - count[i] + n - count[i]
                    traverse(i, root)

        res[0] = get_counts(0, -1)
        traverse(0, -1)
        return res

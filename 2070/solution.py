class Solution:
    def maximumBeauty(self, items: list[list[int]], queries: list[int]) -> list[int]:
        items.sort()
        q = sorted([v, i] for i, v in enumerate(queries))
        res = [0] * len(queries)
        curr = 0
        j = -1
        for v, i in q:
            while j + 1 < len(items) and items[j + 1][0] <= v:
                j += 1
                curr = max(curr, items[j][1])
            res[i] = curr
        return res

class Solution:
    def xorQueries(self, arr: list[int], queries: list[list[int]]) -> list[int]:
        xors = []
        curr = 0
        for num in arr:
            curr ^= num
            xors.append(curr)
        res = []
        for x, y in queries:
            res.append(xors[y] ^ (xors[x - 1] if x > 0 else 0))
        return res

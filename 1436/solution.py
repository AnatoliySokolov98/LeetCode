class Solution:
    def destCity(self, paths: list[list[str]]) -> str:
        src = set()
        dst = set()
        for start, end in paths:
            src.add(start)
            dst.add(end)
        return list(dst - src)[0]

        # time O(n)
        # time O(n)

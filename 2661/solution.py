from collections import defaultdict


class Solution:
    def firstCompleteIndex(self, arr: list[int], mat: list[list[int]]) -> int:
        ROWS, COLS = len(mat), len(mat[0])
        locs = defaultdict(list)
        rows, cols = defaultdict(int), defaultdict(int)
        for r in range(ROWS):
            for c in range(COLS):
                locs[mat[r][c]] = [r, c]
        for i, v in enumerate(arr):
            r, c = locs[v]
            rows[r] += 1
            cols[c] += 1
            if rows[r] == COLS or cols[c] == ROWS:
                return i
        return -1

        # time O(m + n)
        # space O(m)

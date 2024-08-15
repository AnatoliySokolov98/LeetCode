class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        locs = {}
        for i, v in enumerate(s):
            if v in locs:
                locs[v][1] = i
            else:
                locs[v] = [i, i]
        # res = -1
        # for start, end in locs.values():
        #     res = max(res, end - start - 1)
        # return res

        return max([end - start - 1 for start, end in locs.values()])
        # time O(n)
        # space O(1)

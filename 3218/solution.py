class Solution:
    def minimumCost(self, m: int, n: int, h: list[int], v: list[int]) -> int:
        h.sort(reverse=True)
        v.sort(reverse=True)
        res = 0
        i = 0
        j = 0
        hSum = sum(h)
        vSum = sum(v)
        while i < len(h) and j < len(v):
            if h[i] > v[j]:
                res += h[i] * (j + 1)
                hSum -= h[i]
                i += 1
            else:
                res += v[j] * (i + 1)
                vSum -= v[j]
                j += 1
        return res + n * hSum + m * vSum

        # time O(hlog + vlogv)
        # space O(1)

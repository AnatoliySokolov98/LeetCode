from typing import List


class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        N = len(nums)
        Q = len(queries)
        line = [0] * (N + 1)
        curr = k = 0
        for i, v in enumerate(nums):
            curr += line[i]
            while k < Q and curr < v:
                l, r, val = queries[k]
                if l > i:
                    line[l] += val
                    line[r + 1] -= val
                elif l <= i <= r:
                    curr += val
                    line[r + 1] -= val
                k += 1
            if curr < v:
                return -1
        return k

        # time O(m + n)
        # space O(m)

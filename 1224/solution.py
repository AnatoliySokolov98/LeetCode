from collections import defaultdict


class Solution:
    def maxEqualFreq(self, nums: list[int]) -> int:
        res = 1
        counts = defaultdict(int)
        levels = defaultdict(set)
        counts[nums[0]] = 1
        levels[1].add(nums[0])
        for i in range(1, len(nums)):
            curr = nums[i]
            counts[curr] += 1
            nc = counts[curr]
            if nc != 1:
                levels[nc - 1].remove(curr)
                if len(levels[nc - 1]) == 0:
                    del levels[nc - 1]
            levels[nc].add(curr)
            keys = sorted(list(levels.keys()))
            if len(levels) > 2:
                continue
            if len(levels) == 1:
                if 1 in keys or len(levels[keys[0]]) == 1:
                    res = i + 1
                continue
            if 1 in levels and len(levels[1]) == 1:
                res = i + 1
                continue
            l1, l2 = keys
            if l2 == l1 + 1 and len(levels[l2]) == 1:
                res = i + 1
        return res 
       
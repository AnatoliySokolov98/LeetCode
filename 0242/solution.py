from collections import defaultdict


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        counts = defaultdict(int)
        for char in s:
            counts[char] += 1

        for char in t:
            counts[char] -= 1

        return max(counts.values()) == 0

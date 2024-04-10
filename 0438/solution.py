from collections import Counter, defaultdict


class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        p_counts = Counter(p)
        l = 0
        s_counts = defaultdict(int)
        needed = len(p_counts)
        matches = 0
        res = []
        for r in range(len(s)):
            s_counts[s[r]] += 1
            if s_counts[s[r]] == p_counts[s[r]]:
                matches += 1
            while matches == needed and r - l + 1 > len(p):
                if s_counts[s[l]] == p_counts[s[l]]:
                    matches -= 1
                s_counts[s[l]] -= 1
                l += 1
            if r - l + 1 == len(p) and matches == needed:
                res.append(l)
        return res

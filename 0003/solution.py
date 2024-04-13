class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dups = set()
        l = 0
        res = 0
        for r, v in enumerate(s):
            while v in dups:
                dups.remove(s[l])
                l += 1
            dups.add(v)
            res = max(res, r - l + 1)
        return res

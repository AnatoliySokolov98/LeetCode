class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        vowel_to_bit = {"a": 0, "e": 1, "i": 2, "o": 3, "u": 4}
        mask = 0
        locs = {0: -1}
        res = 0

        for i, char in enumerate(s):
            if char in vowel_to_bit:
                mask ^= 1 << vowel_to_bit[char]
            if mask in locs:
                res = max(res, i - locs[mask])
            else:
                locs[mask] = i

        return res

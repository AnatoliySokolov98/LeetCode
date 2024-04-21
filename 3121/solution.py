from collections import defaultdict


class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        locs = defaultdict(int)
        for i, char in enumerate(word):
            if ord(char) >= ord("a"):
                locs[char] = i
            elif char not in locs:
                locs[char] = i
        res = 0
        for key in locs:
            upper = chr(ord(key) - 32)
            if upper in locs and locs[key] < locs[upper]:
                res += 1
        return res

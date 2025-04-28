from functools import cache


class Solution:
    def getLocation(sef, letter):
        loc = ord(letter) - ord('A')
        row = loc // 6
        col = loc % 6
        return row, col

    def minimumDistance(self, word: str) -> int:
        @cache
        def dp(i, r1, c1, r2, c2):
            if i == len(word):
                return 0
            nr, nc = self.getLocation(word[i])
            res = abs(nr - r1) + abs(nc - c1) + dp(i + 1, nr, nc, r2, c2)
            res = min(res, abs(nr - r2) + abs(nc - c2) + dp(i + 1, r1, c1, nr, nc))
            return res
        res = float('inf')
        letters = set(word)
        r1, c1 = self.getLocation(word[0])
        for l in letters:
            r2, c2 = self.getLocation(l)
            res = min(res, dp(0, r1, c1, r2, c2))
        return res
        #time O(n * 26 * 26 + 26 * 26)
        #space O(n * 26 * 26)
            


from collections import deque


class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        max_zeroes = int(len(s) ** 0.5)
        res = 0
        for i in range(max_zeroes + 1):
            l = 0
            zeroes = 0
            ones = 0
            locs = deque()
            square = i**2
            for r in range(len(s)):
                if s[r] == "0":
                    zeroes += 1
                    locs.append(r)
                if s[r] == "1":
                    ones += 1
                while zeroes > i:
                    if s[l] == "0":
                        zeroes -= 1
                        locs.popleft()
                    if s[l] == "1":
                        ones -= 1
                    l += 1
                if zeroes == i and ones >= square:
                    if not locs:
                        res += r - l + 1
                    else:
                        res += min(locs[0] - l + 1, ones - square + 1)
        return res

        # time O(n sqrtn)
        # space O(n)

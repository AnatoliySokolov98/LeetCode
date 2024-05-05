from collections import Counter


class Solution:
    def minAnagramLength(self, s: str) -> int:
        S = len(s)
        for i in range(1, S):
            if S % i != 0:
                continue
            word = Counter(s[:i])
            check = True
            for j in range(i, S, i):
                new_word = Counter(s[j : j + i])
                if word != new_word:
                    check = False
                    break
            if check:
                return i
        return S

        # time O(log(n)26*n)
        # space O(26)

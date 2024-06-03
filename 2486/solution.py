class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        i = 0
        for j in range(len(s)):
            if t[i] == s[j]:
                i += 1
                if i == len(t):
                    return 0
        return len(t) - i

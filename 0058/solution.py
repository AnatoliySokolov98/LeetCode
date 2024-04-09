class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.strip()
        location = len(s) - 1
        res = 0
        while location >= 0 and s[location] != " ":
            location -= 1
            res += 1
        return res

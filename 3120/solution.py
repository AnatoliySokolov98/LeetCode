class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        chars = set(word)
        res = 0
        for key in chars:
            if chr(ord(key) + 32) in chars:
                res += 1
        return res

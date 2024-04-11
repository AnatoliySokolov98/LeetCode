class Solution:
    def partitionString(self, s: str) -> int:
        res = 0
        letters = set()
        for letter in s:
            if letter in letters:
                res += 1
                letters.clear()
            letters.add(letter)
        return res + 1

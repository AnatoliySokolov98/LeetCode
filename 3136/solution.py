class Solution:
    def isValid(self, word: str) -> bool:
        if len(word) < 3 or not word.isalnum():
            return False
        v = 0
        c = 0
        vowels = set("aeiouAEIOU")
        for char in word:
            if char.isalpha():
                if char in vowels:
                    v += 1
                else:
                    c += 1
        return v > 0 and c > 0

        # time O(n)
        # space O(1)

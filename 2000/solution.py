class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        for i, v in enumerate(word):
            if v == ch:
                return word[i::-1] + word[i + 1 :]
        return word

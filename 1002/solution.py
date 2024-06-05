from collections import Counter


class Solution:
    def commonChars(self, words: list[str]) -> list[str]:
        prev = Counter(words[0])
        for i in range(1, len(words)):
            curr = Counter(words[i])
            combination = {}
            for key in curr:
                if key in prev:
                    combination[key] = min(curr[key], prev[key])
            prev = combination
        res = []
        for key, val in prev.items():
            for i in range(val):
                res.append(key)
        return res

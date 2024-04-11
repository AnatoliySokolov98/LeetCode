class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        i, j = 0, 0
        res = []
        ONE, TWO = len(word1), len(word2)
        while i < ONE or j < TWO:
            if i < ONE:
                res.append(word1[i])
                i += 1
            if j < TWO:
                res.append(word2[j])
                j += 1
        return "".join(res)

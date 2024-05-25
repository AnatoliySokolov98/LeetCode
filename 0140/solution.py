class Solution:
    def wordBreak(self, s: str, wordDict: list[str]) -> list[str]:
        res = []
        curr = []
        wordSet = set(wordDict)

        def backtrack(i):
            if i == len(s):
                res.append(" ".join(curr))
                return
            for j in range(i, len(s)):
                word = s[i : j + 1]
                if word in wordSet:
                    curr.append(word)
                    backtrack(j + 1)
                    curr.pop()

        backtrack(0)
        return res

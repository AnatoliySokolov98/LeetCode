class Solution:
    def partition(self, s: str) -> list[list[str]]:
        curr = []
        res = []

        def backtrack(index):
            if index == len(s):
                res.append(curr.copy())
                return
            for i in range(index, len(s)):
                word = s[index : i + 1]
                if word == word[::-1]:
                    curr.append(word)
                    backtrack(i + 1)
                    curr.pop()

        backtrack(0)
        return res

class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        if not digits:
            return []
        letters = {
            2: "abc",
            3: "def",
            4: "ghi",
            5: "jkl",
            6: "mno",
            7: "pqrs",
            8: "tuv",
            9: "wxyz",
        }
        res = []
        curr = []

        def backtrack(index):
            if index == len(digits):
                res.append("".join(curr))
                return
            chars = letters[int(digits[index])]
            for char in chars:
                curr.append(char)
                backtrack(index + 1)
                curr.pop()

        backtrack(0)
        return res

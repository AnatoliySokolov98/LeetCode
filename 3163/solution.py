class Solution:
    def compressedString(self, word: str) -> str:
        res = []
        i = 0
        while i < len(word):
            count = 1
            while count < 9 and i + 1 < len(word) and word[i + 1] == word[i]:
                count += 1
                i += 1
            res.append(str(count))
            res.append(word[i])
            i += 1
        return "".join(res)

        # time O(n)
        # space O(1)

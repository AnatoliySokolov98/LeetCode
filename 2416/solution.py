class Trie:
    def __init__(self):
        self.children = {}
        self.words = 0

    def insert(self, word):
        curr = self
        for char in word:
            if char not in curr.children:
                curr.children[char] = Trie()
            curr = curr.children[char]
            curr.words += 1


class Solution:
    def sumPrefixScores(self, words: list[str]) -> list[int]:
        res = []
        root = Trie()
        for word in words:
            root.insert(word)
        for word in words:
            count = 0
            curr = root
            for char in word:
                curr = curr.children[char]
                count += curr.words
            res.append(count)
        return res

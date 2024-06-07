from typing import List


class Trie:
    def __init__(self):
        self.word = False
        self.children = {}

    def insert(self, word):
        current = self
        for char in word:
            if char not in current.children:
                current.children[char] = Trie()
            current = current.children[char]
            if current.word:
                break
        current.word = True


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = Trie()
        for word in dictionary:
            root.insert(word)

        def find_root(word):
            current = root
            for i, char in enumerate(word):
                if char not in current.children:
                    return word
                current = current.children[char]
                if current.word:
                    return word[: i + 1]
            return word

        result = [find_root(word) for word in sentence.split()]
        return " ".join(result)

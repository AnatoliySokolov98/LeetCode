from collections import defaultdict


class Solution:
    def makeEqual(self, words: list[str]) -> bool:
        counter = defaultdict(int)
        W = len(words)
        for word in words:
            for char in word:
                counter[char] += 1

        for val in counter.values():
            if val % W:
                return False
        return True
        # time O(c * n)
        # space O(1)

from collections import defaultdict


class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        anagrams = defaultdict(list)
        for word in strs:
            sorted_word = "".join(sorted(list(word)))
            anagrams[sorted_word].append(word)
        return anagrams.values()

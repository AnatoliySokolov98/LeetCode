from collections import Counter


class Solution:
    def countCharacters(self, words: list[str], chars: str) -> int:
        chars_count = Counter(chars)
        res = 0
        for word in words:
            word_count = Counter(word)
            valid = True
            for key in word_count:
                if chars_count[key] < word_count[key]:
                    valid = False
                    break
            res += len(word) if valid else 0
        return res
        # time O(c + wc)
        # space O(1)

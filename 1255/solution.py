from typing import Counter


class Solution:
    def maxScoreWords(
        self, words: list[str], letters: list[str], score: list[int]
    ) -> int:
        res = 0
        counts = Counter(letters)
        word_counts = [Counter(word) for word in words]
        curr = 0

        def backtrack(i):
            nonlocal res, curr
            if i == len(words):
                res = max(res, curr)
                return
            check = True
            for key in word_counts[i]:
                if counts[key] < word_counts[i][key]:
                    check = False
                    break
            if check:
                for key in word_counts[i]:
                    counts[key] -= word_counts[i][key]
                    curr += score[ord(key) - ord("a")] * word_counts[i][key]
                backtrack(i + 1)
                for key in word_counts[i]:
                    counts[key] += word_counts[i][key]
                    curr -= score[ord(key) - ord("a")] * word_counts[i][key]
            backtrack(i + 1)

        backtrack(0)
        return res

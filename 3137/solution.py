from collections import defaultdict


class Solution:
    def minimumOperationsToMakeKPeriodic(self, word: str, k: int) -> int:
        counts = defaultdict(int)
        for i in range(0, len(word), k):
            counts[word[i : i + k]] += 1
        total = len(word) // k
        res = float("inf")
        for val in counts.values():
            res = min(res, total - val)
        return res

        # time O(n)
        # space O(n)

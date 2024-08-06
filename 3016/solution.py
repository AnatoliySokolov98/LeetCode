from collections import Counter
from math import ceil


class Solution:
    def minimumPushes(self, word: str) -> int:
        return sum(
            ceil((i + 1) / 8) * v
            for i, v in enumerate(sorted(Counter(word).values(), reverse=True))
        )

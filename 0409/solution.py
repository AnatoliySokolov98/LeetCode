from typing import Counter


class Solution:
    def longestPalindrome(self, s: str) -> int:
        counts = Counter(s)
        pairs = 0
        single = False
        for value in counts.values():
            pairs += value // 2
            single |= value % 2 == 1
        return pairs * 2 + single

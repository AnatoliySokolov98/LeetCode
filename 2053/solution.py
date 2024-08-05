from typing import Counter


class Solution:
    def kthDistinct(self, arr: list[str], k: int) -> str:
        counts = Counter(arr)
        for string in arr:
            if counts[string] == 1:
                k -= 1
                if k == 0:
                    return string
        return ""

class Solution:
    def chalkReplacer(self, chalk: list[int], k: int) -> int:
        total = sum(chalk)
        k %= total
        for i, v in enumerate(chalk):
            if v > k:
                return i
            k -= v
        return -1

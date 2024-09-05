class Solution:
    def missingRolls(self, rolls: list[int], mean: int, n: int) -> list[int]:
        total = sum(rolls)
        count = n + len(rolls)
        missing = count * mean - total
        min_sum = n
        max_sum = n * 6
        if missing < min_sum or missing > max_sum:
            return []
        val = missing // n
        extra = missing % n
        res = [val + 1] * extra + [val] * (n - extra)
        return res

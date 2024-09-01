class Solution:
    def construct2DArray(self, original: list[int], m: int, n: int) -> list[list[int]]:
        if m * n != len(original):
            return []
        return [original[i * n : (i + 1) * n] for i in range(m)]

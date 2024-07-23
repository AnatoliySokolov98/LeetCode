from typing import Counter


class Solution:
    def frequencySort(self, nums: list[int]) -> list[int]:
        counts = Counter(nums)
        return sorted([num for num in nums], key=lambda x: (counts[x], -x))

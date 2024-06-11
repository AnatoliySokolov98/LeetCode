from typing import Counter


class Solution:
    def relativeSortArray(self, arr1: list[int], arr2: list[int]) -> list[int]:
        counts = Counter(arr1)
        res = []
        for num in arr2:
            for _ in range(counts[num]):
                res.append(num)
        arr2 = set(arr2)
        extra = []
        for num in arr1:
            if num not in arr2:
                extra.append(num)
        extra.sort()
        return res + extra

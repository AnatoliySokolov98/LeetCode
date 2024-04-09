class Solution:
    def replaceElements(self, arr: list[int]) -> list[int]:
        greatest = -1
        for i in range(len(arr) - 1, -1, -1):
            greatest, arr[i] = max(greatest, arr[i]), greatest
        return arr

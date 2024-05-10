from heapq import heappop, heappush


class Solution:
    def kthSmallestPrimeFraction(self, arr: list[int], k: int) -> list[int]:
        visited = set()
        A = len(arr)
        heap = [(arr[0] / arr[A - 1], 0, A - 1)]
        while True:
            _, i, j = heappop(heap)
            k -= 1
            if k == 0:
                return [arr[i], arr[j]]
            if j > i + 1 and (i, j - 1) not in visited:
                heappush(heap, (arr[i] / arr[j - 1], i, j - 1))
                visited.add((i, j - 1))
            if i + 1 < j and (i + 1, j) not in visited:
                heappush(heap, (arr[i + 1] / arr[j], i + 1, j))
                visited.add((i + 1, j))
        return [0, 0]

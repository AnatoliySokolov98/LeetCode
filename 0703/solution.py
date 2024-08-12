from heapq import heappop, heappush


class KthLargest:
    def __init__(self, k: int, nums: list[int]):
        self.heap = sorted(nums[:])[-k:]
        self.K = k

    def add(self, val: int) -> int:
        heappush(self.heap, val)
        if len(self.heap) > self.K:
            heappop(self.heap)
        return self.heap[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)

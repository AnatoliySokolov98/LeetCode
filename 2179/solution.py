class BIT:
    def __init__(self, n):
        self.nums = [0] * (n + 1)
        self.N = n
    def update(self, idx):
        idx += 1
        while idx <= self.N:
            self.nums[idx] += 1
            idx += idx & -idx                    
    def query(self, idx):
        idx += 1
        res = 0
        while idx > 0:
            res += self.nums[idx]
            idx -= idx & -idx
        return res
        
class Solution:
    def goodTriplets(self, nums1: list[int], nums2: list[int]) -> int:
        N = len(nums1)
        bit = BIT(N + 1)
        locs = [0] * N
        for i, v in enumerate(nums2):
            locs[v] = i
        lefts, rights = [0] * N, [0] * N
        for i, v in enumerate(nums1):
            loc = locs[v]
            lefts[i] = bit.query(loc - 1)
            bit.update(loc)
        bit = BIT(N + 1)
        for i in range(N - 1, -1, -1):
            loc = locs[nums1[i]]
            rights[i] = bit.query(N) - bit.query(loc)
            bit.update(loc)
        res = 0
        for i in range(N):
            res += lefts[i] * rights[i]
        return res
#time O(nlogn)
#space O(n)
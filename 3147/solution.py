class Solution:
    def maximumEnergy(self, energy: list[int], k: int) -> int:
        res = float("-inf")
        for i in range(k):
            curr = 0
            for j in range(i, len(energy), k):
                curr = max(energy[j] + curr, energy[j])
            res = max(res, curr)
        return res

        # time O(n)
        # space O(1)

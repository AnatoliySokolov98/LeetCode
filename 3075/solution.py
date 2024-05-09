class Solution:
    def maximumHappinessSum(self, happiness: list[int], k: int) -> int:
        happiness.sort(reverse=True)
        res = 0
        for i in range(k):
            val = happiness[i] - i
            if val <= 0:
                return res
            res += val
        return res
        # time O(nlogn)
        # space O(1)

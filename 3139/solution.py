class Solution:
    def minCostToEqualizeArray(self, nums: list[int], cost1: int, cost2: int) -> int:
        N = len(nums)
        b, s = max(nums), min(nums)
        total = sum(b - num for num in nums)
        singles = max((b - s) * 2 - total, 0)
        MOD = 10**9 + 7

        if N <= 2 or cost1 <= cost2 // 2:
            return total * cost1 % MOD

        # try just using pairs and single for the rest
        pairs = total - singles
        res = (pairs % 2 + singles) * cost1 + (pairs // 2) * cost2

        # try combining single number with all the rest
        total += (singles // (N - 2)) * (N)
        singles %= N - 2
        pairs = total - singles
        res = min(res, (singles + pairs % 2) * cost1 + pairs // 2 * cost2)

        # try raising the max even more so that we minimize cost1 ops
        for _ in range(2 if N % 2 else 1):
            total += N
            res = min(res, total % 2 * cost1 + total // 2 * cost2)
        return res % MOD

        # time O(n)
        # space O(1)

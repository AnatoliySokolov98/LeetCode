class Solution:
    def maxProfitAssignment(
        self, difficulty: list[int], profit: list[int], worker: list[int]
    ) -> int:
        pairs = sorted(zip(difficulty, profit))
        worker.sort()
        profit = pairs[0][1]
        p = 0
        res = 0
        for w in worker:
            while p + 1 < len(pairs) and pairs[p + 1][0] <= w:
                p += 1
                profit = max(profit, pairs[p][1])
            if pairs[p][0] <= w:
                res += profit
        return res

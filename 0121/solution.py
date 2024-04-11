class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        res = 0
        curr = float("inf")
        for price in prices:
            res = max(res, price - curr)
            curr = min(curr, price)
        return res

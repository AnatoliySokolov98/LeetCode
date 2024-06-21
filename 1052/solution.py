class Solution:
    def maxSatisfied(
        self, customers: list[int], grumpy: list[int], minutes: int
    ) -> int:
        curr = 0
        for i in range(len(customers)):
            curr += customers[i] if not grumpy[i] else 0
        res = curr
        for i in range(len(customers)):
            curr += customers[i] if grumpy[i] else 0
            if i >= minutes:
                curr -= customers[i - minutes] if grumpy[i - minutes] else 0
            res = max(res, curr)
        return res

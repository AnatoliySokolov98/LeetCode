class Solution:
    def timeRequiredToBuy(self, tickets: list[int], k: int) -> int:
        k_tickets = tickets[k]
        res = tickets[k]
        for i, v in enumerate(tickets):
            if i < k:
                res += min(v, k_tickets)
            elif i > k:
                res += min(k_tickets - 1, v)
        return res

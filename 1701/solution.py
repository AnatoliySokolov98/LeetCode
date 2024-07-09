class Solution:
    def averageWaitingTime(self, customers: list[list[int]]) -> float:
        total = 0
        time = 0
        for start, wait in customers:
            if time < start:
                time = start
            time += wait
            total += time - start
        return total / len(customers)

from collections import deque


class Solution:
    def deckRevealedIncreasing(self, deck: list[int]) -> list[int]:
        deck.sort()
        D = len(deck)
        res = [None] * D
        queue = deque([i for i in range(D)])
        i = 0
        while queue:
            curr = queue.popleft()
            res[curr] = deck[i]
            i += 1
            if queue:
                queue.append(queue.popleft())
        return res

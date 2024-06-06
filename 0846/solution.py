from typing import Counter


class Solution:
    def isNStraightHand(self, hand: list[int], groupSize: int) -> bool:
        H = len(hand)
        if H % groupSize != 0:
            return False
        counts = Counter(hand)
        keys = sorted(counts.keys())
        for key in keys:
            while counts[key] > 0:
                for i in range(groupSize):
                    if counts[key + i] == 0:
                        return False
                    counts[key + i] -= 1
        return True

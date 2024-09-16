from collections import defaultdict


class Solution:
    def findMinDifference(self, timePoints: list[str]) -> int:
        smallest = float("inf")
        biggest = float("-inf")
        times = defaultdict(int)
        res = float("inf")
        for time in timePoints:
            hours, minutes = time.split(":")
            curr = 60 * int(hours) + int(minutes)
            smallest = min(smallest, curr)
            biggest = max(curr, biggest)
            times[curr] += 1
        curr = float("-inf")
        for time in range(smallest, biggest + 1):
            if time in times:
                if times[time] > 1:
                    return 0
                res = min(res, time - curr)
                curr = time
        res = min(res, smallest + 24 * 60 - biggest)
        return res

class Solution:
    def countDays(self, days: int, meetings: list[list[int]]) -> int:
        res = 0
        meetings.sort()
        end = 0
        for x, y in meetings:
            if x > end:
                res += x - end - 1
                end = y
            else:
                end = max(y, end)
        res += days - end
        return res
        # time O(nlogn)
        # space O(1)

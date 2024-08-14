class Solution:
    def maxScore(self, s: str) -> int:
        ones = 0
        for char in s:
            if char == "1":
                ones += 1
        zeroes = 0
        res = 0
        for i in range(len(s) - 1):
            if s[i] == "0":
                zeroes += 1
            else:
                ones -= 1
            res = max(res, zeroes + ones)
        return res
        # time O(n)
        # space O(1)

class Solution:
    def maxOperations(self, s: str) -> int:
        res = 0
        gaps = 1 if s[-1] == "0" else 0
        for i in range(len(s) - 2, -1, -1):
            if s[i] == "0" and s[i + 1] == "1":
                gaps += 1
            elif s[i] == "1":
                res += gaps
        return res

        # time O(n)
        # space O(1)

from collections import Counter


class Solution:
    def minimumDeletions(self, s: str) -> int:
        S = len(s)
        lb = Counter(s)["b"]
        ra = 0
        res = min(S - lb, lb)
        for i in range(S - 1, -1, -1):
            lb -= s[i] == "b"
            if s[i] == "b":
                res = min(res, lb + ra)
            ra += s[i] == "a"
        return res

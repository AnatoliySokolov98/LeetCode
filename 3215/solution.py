class Solution:
    def getSmallestString(self, s: str) -> str:
        for i in range(len(s) - 1):
            one, two = int(s[i]), int(s[i + 1])
            if one % 2 == two % 2 and one > two:
                res = list(s)
                res[i], res[i + 1] = res[i + 1], res[i]
                return "".join(res)
        return s

        # time O(n)
        # space O(1)

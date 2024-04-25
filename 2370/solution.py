from collections import defaultdict


class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        # @cache
        # def dp(i, last):
        #     if i == len(s):
        #         return 0
        #     if last == None:
        #         res = max(1 + dp(i + 1, s[i]), dp(i + 1, None))
        #     else:
        #         res = dp(i + 1, last)
        #         if abs(ord(last) - ord(s[i])) <= k:
        #             res = max(res, 1 + dp(i + 1, s[i]))
        #     return res
        # return dp(0, None)

        dp = defaultdict(int)
        for i in range(len(s)):
            char_value = ord(s[i])
            char_total = 1
            for key, val in dp.items():
                if abs(key - char_value) <= k:
                    char_total = max(val + 1, char_total)
            dp[char_value] = char_total
        return max(dp.values())

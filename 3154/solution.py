from functools import cache


class Solution:
    def waysToReachStair(self, k: int) -> int:
        @cache
        def dp(i, back, jump):
            if i > k + 1:
                return 0
            res = 0 if i != k else 1
            if back and i != 0:
                res += dp(i - 1, False, jump)
            res += dp(i + 2**jump, True, jump + 1)
            return res

        return dp(1, True, 0)
        # time O(klog(k))
        # space O(klog(k))

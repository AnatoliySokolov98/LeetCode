from functools import cache


class Solution:
    def digitsCount(self, d: int, low: int, high: int) -> int:
        @cache
        def dp(i, num, is_num, no_limit, digit_count):
            if i == len(num):
                return digit_count if is_num else 0
            res = 0
            if not is_num:
                res = dp(i + 1, num, False, True, digit_count)
            l = 1 if not is_num else 0
            r = 9 if no_limit else int(num[i])
            for j in range(l, r + 1):
                res += dp(i + 1, num, True, no_limit or j < int(num[i]), digit_count + (j == d))
            return res
        right = dp(0, str(high), False, False, 0)
        if low == 1:
            return right
        left = dp(0, str(low - 1), False, False, 0)
        return right - left
        
        #time O(log(high))
        #space O(log(high))
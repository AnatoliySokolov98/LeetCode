from math import ceil


class Solution:
    def maxHeightOfTriangle(self, red: int, blue: int) -> int:
        l, r = 0, blue + red
        res = 0
        while l <= r:
            p = (l + r) // 2
            blue_rows = ceil(p / 2)
            red_rows = p // 2
            blue_balls = blue_rows**2
            red_balls = red_rows**2 + red_rows
            if (blue_balls <= blue and red_balls <= red) or (
                blue_balls <= red and red_balls <= blue
            ):
                res = p
                l = p + 1
            else:
                r = p - 1
        return res

        # time O(log(red + blue))
        # space O(1)

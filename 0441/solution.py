class Solution:
    def arrangeCoins(self, n: int) -> int:
        left, right = 1, n
        res = 1
        while left <= right:
            pivot = (right + left) // 2
            coins_needed = pivot * (pivot + 1) // 2
            if coins_needed == n:
                return pivot
            if coins_needed > n:
                right = pivot - 1
            else:
                left = pivot + 1
                res = pivot
        return res

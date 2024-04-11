class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        left, right = 1, num
        while left <= right:
            pivot = (left + right) // 2
            square = pivot * pivot
            if square == num:
                return True
            if square > num:
                right = pivot - 1
            else:
                left = pivot + 1
        return False

        # time O(log(n))
        # space O(1)

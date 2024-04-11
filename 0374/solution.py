# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:
def guess(num):
    pass


class Solution:
    def guessNumber(self, n: int) -> int:
        left, right = 1, n
        while left <= right:
            print(left, right)
            pivot = (right + left) // 2
            result = guess(pivot)
            if result == 0:
                return pivot
            if result == -1:
                right = pivot - 1
            else:
                left = pivot + 1

    # time O(log(n))
    # space O(1)

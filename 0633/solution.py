from math import sqrt


class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        for i in range(int(sqrt(c)) + 1):
            b = c - (i**2)
            root = int(sqrt(b))
            if root * root == b:
                return True
        return False

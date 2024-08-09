class Solution:
    def largestGoodInteger(self, num: str) -> str:
        res = ""
        for i in range(1, len(num) - 1):
            if num[i] == num[i - 1] == num[i + 1]:
                res = max(res, num[i])
        return res * 3

    # time O(n)
    # space O(1)

class Solution:
    def numSteps(self, s: str) -> int:
        res = 0
        carry = 0
        for i in range(len(s) - 1, 0, -1):
            curr = int(s[i]) + carry
            if curr == 2:
                res += 1
                carry = 1
            elif curr == 1:
                res += 2
                carry = 1
            else:
                res += 1
                carry = 0
        return res + carry

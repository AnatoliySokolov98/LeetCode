class Solution:
    def minimumSteps(self, s: str) -> int:
        res = 0
        write_to = len(s) - 1
        for i in range(len(s) - 1, -1, -1):
            if s[i] == "1":
                res += write_to - i
                write_to -= 1
        return res

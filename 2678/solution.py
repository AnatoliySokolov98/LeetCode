class Solution:
    def countSeniors(self, details: list[str]) -> int:
        res = 0
        for detail in details:
            res += int(detail[-4:-2]) > 60
        return res

class Solution:
    def getLucky(self, s: str, k: int) -> int:
        res = 0
        for char in s:
            num = ord(char) - ord("a") + 1
            while num:
                res += num % 10
                num //= 10
        k -= 1
        while k:
            new_res = 0
            while res:
                new_res += res % 10
                res //= 10
            k -= 1
            res = new_res
        return res

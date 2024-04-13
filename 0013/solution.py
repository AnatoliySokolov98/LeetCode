class Solution:
    def romanToInt(self, s: str) -> int:
        res = 0
        i = 0
        while i < len(s):
            if s[i] == "I":
                if s[i : i + 2] == "IV":
                    res += 4
                    i += 1
                elif s[i : i + 2] == "IX":
                    res += 9
                    i += 1
                else:
                    res += 1
            elif s[i] == "V":
                res += 5
            elif s[i] == "X":
                if s[i : i + 2] == "XL":
                    res += 40
                    i += 1
                elif s[i : i + 2] == "XC":
                    res += 90
                    i += 1
                else:
                    res += 10
            elif s[i] == "L":
                res += 50
            elif s[i] == "C":
                if s[i : i + 2] == "CD":
                    res += 400
                    i += 1
                elif s[i : i + 2] == "CM":
                    res += 900
                    i += 1
                else:
                    res += 100
            elif s[i] == "D":
                res += 500
            elif s[i] == "M":
                res += 1000
            i += 1

        return res

        # time(O(n))
        # space(O(1))

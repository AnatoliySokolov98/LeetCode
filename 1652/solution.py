class Solution:
    def decrypt(self, code: list[int], k: int) -> list[int]:
        if k == 0:
            return [0] * len(code)
        l = 1 if k > 0 else len(code) + k
        k = abs(k)
        r = l - 1
        total = 0
        for i in range(k):
            r += 1
            total += code[r]
        res = [0] * len(code)
        res[0] = total
        for i in range(len(code) - 1):
            r = (r + 1) % len(code)
            total += code[r]
            total -= code[l]
            l = (l + 1) % len(code)
            res[i + 1] = total
        return res

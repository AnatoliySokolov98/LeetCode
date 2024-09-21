class Solution:
    def lexicalOrder(self, n: int) -> list[int]:
        res = [1]
        while len(res) < n:
            curr = res[-1]
            if curr * 10 <= n:
                res.append(curr * 10)
                continue
            while curr % 10 == 9 or curr + 1 > n:
                curr //= 10
            res.append(curr + 1)
        return res

class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        cols = set()
        left_diag = set()
        right_diag = set()
        res = []
        curr = []

        def backtrack(row):
            if row == n:
                res.append(curr.copy())
                return
            for col in range(n):
                if col in cols or col - row in left_diag or col + row in right_diag:
                    continue
                cols.add(col)
                left_diag.add(col - row)
                right_diag.add(col + row)
                curr.append("." * col + "Q" + "." * (n - col - 1))
                backtrack(row + 1)
                curr.pop()
                cols.remove(col)
                left_diag.remove(col - row)
                right_diag.remove(col + row)

        backtrack(0)
        return res

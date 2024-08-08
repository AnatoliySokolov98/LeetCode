class Solution:
    def spiralMatrixIII(
        self, rows: int, cols: int, rStart: int, cStart: int
    ) -> list[list[int]]:
        total = rows * cols
        res = [[rStart, cStart]]
        curr = [rStart, cStart]
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        d = 0
        moves = 0

        while len(res) < total:
            steps = (moves // 2) + 1
            for _ in range(steps):
                curr[0] += directions[d][0]
                curr[1] += directions[d][1]
                if 0 <= curr[0] < rows and 0 <= curr[1] < cols:
                    res.append(curr[:])
            d = (d + 1) % 4
            moves += 1

        return res

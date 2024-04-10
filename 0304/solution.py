class NumMatrix:

    def __init__(self, matrix: list[list[int]]):
        self.ROWS = len(matrix)
        self.COLS = len(matrix[0])
        self.prefixes = [
            [0 for _ in range(self.COLS + 1)] for _ in range(self.ROWS + 1)
        ]
        for row in range(self.ROWS):
            total = 0
            for col in range(self.COLS):
                total += matrix[row][col]
                self.prefixes[row + 1][col + 1] = total + self.prefixes[row][col + 1]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return (
            self.prefixes[row2 + 1][col2 + 1]
            - self.prefixes[row1][col2 + 1]
            - self.prefixes[row2 + 1][col1]
            + self.prefixes[row1][col1]
        )

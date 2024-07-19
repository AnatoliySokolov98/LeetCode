class Solution:
    def luckyNumbers(self, matrix: list[list[int]]) -> list[int]:
        ROWS, COLS = len(matrix), len(matrix[0])
        row_min_val, row_min_index = float("-inf"), -1

        for row in range(ROWS):
            row_min = min(matrix[row])
            if row_min > row_min_val:
                row_min_val = row_min
                row_min_index = row

        for col in range(COLS):
            if matrix[row_min_index][col] == row_min_val:
                if all(matrix[row][col] <= row_min_val for row in range(ROWS)):
                    return [row_min_val]

        return []

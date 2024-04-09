from collections import defaultdict


class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        rows = defaultdict(set)
        columns = defaultdict(set)
        boxes = defaultdict(set)

        ROWS, COLUMNS = len(board), len(board[0])

        for row in range(ROWS):
            for column in range(COLUMNS):
                if board[row][column] == ".":
                    continue
                digit = board[row][column]
                if digit in rows[row] or digit in columns[column]:
                    return False
                rows[row].add(digit)
                columns[column].add(digit)
                if digit in boxes[(row // 3, column // 3)]:
                    return False
                boxes[(row // 3, column // 3)].add(digit)
        return True

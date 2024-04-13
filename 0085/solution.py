class Solution:
    def maximalRectangle(self, matrix: list[list[str]]) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        totals = [0] * COLS
        area = 0

        def rectangle_area(rectangles):
            stack = []
            max_area = 0
            for i in range(len(rectangles)):
                while stack and rectangles[i] < rectangles[stack[-1]]:
                    item = rectangles[stack.pop()]
                    if not stack:
                        left = -1
                    else:
                        left = stack[-1]
                    right = i

                    max_area = max(max_area, (right - left - 1) * item)
                stack.append(i)
            while stack:
                item = rectangles[stack.pop()]
                if not stack:
                    left = -1
                else:
                    left = stack[-1]
                right = len(rectangles)

                max_area = max(max_area, (right - left - 1) * item)
            return max_area

        for row in range(ROWS):
            for col in range(COLS):
                if matrix[row][col] == "1":
                    totals[col] += 1
                else:
                    totals[col] = 0
            area = max(area, rectangle_area(totals))

        return area

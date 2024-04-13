import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int[] totals = new int[COLS];
        int area = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (matrix[row][col] == '1') {
                    totals[col] += 1;
                } else {
                    totals[col] = 0;
                }
            }
            area = Math.max(area, rectangleArea(totals));
        }
        return area;
    }

    public int rectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int tp = stack.pop();
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, heights[tp] * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int tp = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - 1 - stack.peek();
            maxArea = Math.max(maxArea, heights[tp] * width);
        }
        return maxArea;
    }
}

// time O(n*m)
// space O(m)
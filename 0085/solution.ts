function maximalRectangle(matrix: string[][]): number {
  const ROWS = matrix.length;
  const COLS = matrix[0].length;
  let totals: number[] = new Array(COLS).fill(0);
  let area = 0;

  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) {
      if (matrix[row][col] === "1") {
        totals[col]++;
      } else {
        totals[col] = 0;
      }
    }
    area = Math.max(area, rectangleArea(totals));
  }
  return area;
}

function rectangleArea(heights: number[]): number {
  let stack: number[] = [];
  let maxArea = 0;
  for (let i = 0; i < heights.length; i++) {
    while (stack.length > 0 && heights[i] < heights[stack[stack.length - 1]]) {
      let height = heights[stack.pop()!];
      let width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;
      maxArea = Math.max(maxArea, height * width);
    }
    stack.push(i);
  }
  while (stack.length > 0) {
    let height = heights[stack.pop()!];
    let width =
      stack.length === 0
        ? heights.length
        : heights.length - stack[stack.length - 1] - 1;
    maxArea = Math.max(maxArea, height * width);
  }
  return maxArea;
}

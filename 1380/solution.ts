function luckyNumbers(matrix: number[][]): number[] {
  const ROWS = matrix.length;
  const COLS = matrix[0].length;
  let luckyNumber = -1;
  let i = -1;

  for (let row = 0; row < ROWS; row++) {
    let rowMin = Infinity;
    for (let col = 0; col < COLS; col++) {
      rowMin = Math.min(rowMin, matrix[row][col]);
    }
    if (rowMin > luckyNumber) {
      i = row;
      luckyNumber = rowMin;
    }
  }

  for (let col = 0; col < COLS; col++) {
    if (matrix[i][col] == luckyNumber) {
      for (let row = 0; row < ROWS; row++) {
        if (matrix[row][col] > luckyNumber) {
          return [];
        }
      }
      return [luckyNumber];
    }
  }
  return [];
}

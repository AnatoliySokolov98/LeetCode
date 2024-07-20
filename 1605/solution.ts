function restoreMatrix(rowSum: number[], colSum: number[]): number[][] {
  const ROWS = rowSum.length;
  const COLS = colSum.length;
  const res = new Array(ROWS).fill(0).map((row) => new Array(COLS).fill(0));

  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) {
      res[row][col] += Math.min(rowSum[row], colSum[col]);
      rowSum[row] -= res[row][col];
      colSum[col] -= res[row][col];
    }
  }
  return res;
}

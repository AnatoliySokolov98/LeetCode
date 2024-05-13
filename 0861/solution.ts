function matrixScore(grid: number[][]): number {
  const ROWS = grid.length;
  const COLS = grid[0].length;
  let res = (1 << (COLS - 1)) * ROWS;
  for (let col = 1; col < COLS; col++) {
    let colTotal = 0;
    for (let row = 0; row < ROWS; row++) {
      colTotal += grid[row][0] == 1 ? grid[row][col] : 1 - grid[row][col];
    }
    res += Math.max(colTotal, ROWS - colTotal) * (1 << (COLS - col - 1));
  }
  return res;
}

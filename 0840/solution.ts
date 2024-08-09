function numMagicSquaresInside(grid: number[][]): number {
  const ROWS = grid.length;
  const COLS = grid[0].length;
  let res = 0;

  for (let r = 0; r < ROWS - 2; r++) {
    for (let c = 0; c < COLS - 2; c++) {
      if (isValidSquare(grid, r, c)) {
        res += 1;
      }
    }
  }
  return res;
}

function isValidSquare(grid: number[][], x: number, y: number) {
  if (grid[x + 1][y + 1] != 5) {
    return false;
  }

  const s = 15;
  const seen = new Set<number>();

  for (let r = 0; r < 3; r++) {
    let rowSum = 0;
    for (let c = 0; c < 3; c++) {
      let val = grid[x + r][y + c];
      if (val < 1 || val > 9 || seen.has(val)) {
        return false;
      }
      seen.add(val);
      rowSum += val;
    }
    if (rowSum != s) {
      return false;
    }
  }

  for (let c = 0; c < 3; c++) {
    let colSum = 0;
    for (let r = 0; r < 3; r++) {
      colSum += grid[x + r][y + c];
    }
    if (colSum != s) {
      return false;
    }
  }

  const diag1 = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
  const diag2 = grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];

  return diag1 == s && diag2 == s;
}

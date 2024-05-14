function getMaximumGold(grid: number[][]): number {
  const ROWS = grid.length;
  const COLS = grid[0].length;
  const dirs = [
    [1, 0],
    [0, 1],
    [-1, 0],
    [0, -1],
  ];
  const visited = new Array(ROWS)
    .fill(false)
    .map((el) => new Array(COLS).fill(false));
  let totalGold = 0;
  let res = 0;
  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) {
      totalGold += grid[row][col];
    }
  }

  const dfs = (row: number, col: number) => {
    if (
      row < 0 ||
      row == ROWS ||
      col < 0 ||
      col == COLS ||
      grid[row][col] == 0 ||
      visited[row][col] == true
    ) {
      return 0;
    }
    let res = grid[row][col];
    visited[row][col] = true;
    for (const dir of dirs) {
      res = Math.max(res, grid[row][col] + dfs(row + dir[0], col + dir[1]));
      if (res == totalGold) {
        return totalGold;
      }
    }
    visited[row][col] = false;
    return res;
  };

  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) res = Math.max(res, dfs(row, col));
    if (res == totalGold) {
      return totalGold;
    }
  }
  return res;
}

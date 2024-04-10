function gridGame(grid: number[][]): number {
  const COLS = grid[0].length;
  const prefixes = [[...grid[0]], [...grid[1]]];
  let res = Infinity;
  for (let i = 0; i < 2; i++) {
    for (let j = 1; j < COLS; j++) {
      prefixes[i][j] = prefixes[i][j - 1] + prefixes[i][j];
    }
  }
  for (let i = 0; i < COLS; i++) {
    res = Math.min(
      res,
      Math.max(
        prefixes[0][COLS - 1] - prefixes[0][i],
        i === 0 ? 0 : prefixes[1][i - 1]
      )
    );
  }
  return res;
}

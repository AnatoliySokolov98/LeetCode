function regionsBySlashes(grid: string[]): number {
  const N = grid.length;
  const newGrid = new Array(N * 3)
    .fill(0)
    .map((row) => new Array(N * 3).fill(0));

  for (let r = 0; r < N; r++) {
    for (let c = 0; c < N; c++) {
      const ch = grid[r][c];
      if (ch == "/") {
        newGrid[r * 3][c * 3 + 2] = 1;
        newGrid[r * 3 + 1][c * 3 + 1] = 1;
        newGrid[r * 3 + 2][c * 3] = 1;
      } else if (ch == "\\") {
        newGrid[r * 3][c * 3] = 1;
        newGrid[r * 3 + 1][c * 3 + 1] = 1;
        newGrid[r * 3 + 2][c * 3 + 2] = 1;
      }
    }
  }

  let res = 0;
  for (let r = 0; r < N * 3; r++) {
    for (let c = 0; c < N * 3; c++) {
      if (newGrid[r][c] == 0) {
        res++;
        dfs(newGrid, r, c, N * 3);
      }
    }
  }
  return res;
}

function dfs(grid: number[][], r: number, c: number, N: number) {
  if (r < 0 || r >= N || c < 0 || c >= N || grid[r][c] == 1) {
    return;
  }
  grid[r][c] = 1;
  dfs(grid, r + 1, c, N);
  dfs(grid, r - 1, c, N);
  dfs(grid, r, c + 1, N);
  dfs(grid, r, c - 1, N);
}

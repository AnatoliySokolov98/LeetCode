function largestLocal(grid: number[][]): number[][] {
  const N = grid.length;
  const res = new Array(N - 2).fill(0).map((el) => new Array(N - 2).fill(0));
  for (let row = 0; row < N - 2; row++) {
    for (let col = 0; col < N - 2; col++) {
      for (let i = -1; i < 2; i++) {
        for (let j = -1; j < 2; j++) {
          res[row][col] = Math.max(
            res[row][col],
            grid[row + i + 1][col + j + 1]
          );
        }
      }
    }
  }
  return res;
}

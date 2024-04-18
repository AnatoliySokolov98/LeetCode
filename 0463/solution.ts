function islandPerimeter(grid: number[][]): number {
  const ROWS = grid.length;
  const COLS = grid[0].length;
  const dirs = [
    [1, 0],
    [0, 1],
    [-1, 0],
    [0, -1],
  ];
  let res = 0;
  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) {
      for (const [r, c] of dirs) {
        if (grid[row][col] != 1) {
          continue;
        }
        const x = row + r;
        const y = col + c;
        if (x < 0 || x == ROWS || y < 0 || y == COLS || grid[x][y] == 0) {
          res++;
        }
      }
    }
  }
  return res;
}

function numIslands(grid: string[][]): number {
  const ROWS = grid.length;
  const COLS = grid[0].length;
  const directions = [
    [1, 0],
    [0, 1],
    [-1, 0],
    [0, -1],
  ];
  const visited = new Array(ROWS)
    .fill(null)
    .map(() => new Array(COLS).fill(false));
  let islands = 0;

  const dfs = (row: number, col: number): void => {
    visited[row][col] = true;
    for (let [r, c] of directions) {
      const x = row + r;
      const y = col + c;
      if (
        x < 0 ||
        x == ROWS ||
        y < 0 ||
        y == COLS ||
        visited[x][y] ||
        grid[x][y] === "0"
      ) {
        continue;
      }
      dfs(x, y);
    }
  };

  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) {
      if (grid[row][col] === "1" && !visited[row][col]) {
        islands++;
        dfs(row, col);
      }
    }
  }

  return islands;
}

//time O(rows * cols)
//space O(rows * cols)

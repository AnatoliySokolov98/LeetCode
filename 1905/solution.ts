function countSubIslands(grid1: number[][], grid2: number[][]): number {
  const ROWS = grid1.length;
  const COLS = grid1[0].length;
  const dirs = [
    [1, 0],
    [0, 1],
    [-1, 0],
    [0, -1],
  ];
  const visited = new Array(ROWS)
    .fill(0)
    .map((el) => new Array(COLS).fill(false));
  let islands = 0;
  const dfs = (row: number, col: number): boolean => {
    if (
      row < 0 ||
      row == ROWS ||
      col < 0 ||
      col == COLS ||
      grid2[row][col] === 0 ||
      visited[row][col]
    ) {
      return true;
    }
    visited[row][col] = true;
    let check = true;
    if (grid1[row][col] === 0) {
      check = false;
    }

    for (const [x, y] of dirs) {
      if (!dfs(row + x, col + y)) {
        check = false;
      }
    }
    return check;
  };

  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) {
      if (!visited[row][col] && grid2[row][col] === 1 && dfs(row, col)) {
        islands++;
      }
    }
  }
  return islands;
}

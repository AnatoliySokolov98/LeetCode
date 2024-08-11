function minDays(grid: number[][]): number {
  const ROWS = grid.length;
  const COLS = grid[0].length;
  const directions = [
    [1, 0],
    [0, 1],
    [-1, 0],
    [0, -1],
  ];
  let islands = 0;
  const visited = new Set<string>();

  function dfs(row: number, col: number, visited: Set<string>): void {
    if (
      row < 0 ||
      row >= ROWS ||
      col < 0 ||
      col >= COLS ||
      visited.has(`${row},${col}`) ||
      grid[row][col] === 0
    ) {
      return;
    }
    visited.add(`${row},${col}`);
    for (const [x, y] of directions) {
      dfs(row + x, col + y, visited);
    }
  }

  // Count the number of islands
  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) {
      if (grid[row][col] === 1 && !visited.has(`${row},${col}`)) {
        islands++;
        dfs(row, col, visited);
      }
    }
  }

  if (islands !== 1) {
    return 0;
  }
  if (visited.size <= 2) {
    return visited.size;
  }

  let minConnections = Infinity;

  // Calculate the minimum connections for any land cell
  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col < COLS; col++) {
      if (visited.has(`${row},${col}`)) {
        let connections = 0;
        for (const [x, y] of directions) {
          const newRow = row + x;
          const newCol = col + y;
          if (
            newRow >= 0 &&
            newRow < ROWS &&
            newCol >= 0 &&
            newCol < COLS &&
            grid[newRow][newCol] === 1
          ) {
            connections++;
          }
        }
        minConnections = Math.min(minConnections, connections);
      }
    }
  }

  if (minConnections === 1) {
    return 1;
  }

  // Check if removing one land cell disconnects the island
  for (const cell of visited) {
    const [x, y] = cell.split(",").map(Number);
    for (const [r, c] of directions) {
      const nr = x + r;
      const nc = y + c;
      if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] === 0) {
        continue;
      } else {
        grid[x][y] = 0;
        const newVisited = new Set<string>();
        dfs(nr, nc, newVisited);
        if (newVisited.size !== visited.size - 1) {
          return 1;
        }
        grid[x][y] = 1;
      }
    }
  }

  return 2;
}

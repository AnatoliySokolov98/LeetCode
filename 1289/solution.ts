function minFallingPathSum(grid: number[][]): number {
  const N = grid.length;
  if (N === 1) {
    return grid[0][0];
  }
  let prevRow: Array<[number, number]> = [
    [0, -1],
    [0, -1],
  ];

  for (let row = 0; row < N; row++) {
    const currRow: Array<[number, number]> = [];
    for (let col = 0; col < N; col++) {
      if (col !== prevRow[0][1]) {
        currRow.push([prevRow[0][0] + grid[row][col], col]);
      } else {
        currRow.push([prevRow[1][0] + grid[row][col], col]);
      }
      if (currRow.length > 2) {
        currRow.sort((a, b) => a[0] - b[0]);
        currRow.pop();
      }
    }
    prevRow = currRow;
  }
  return prevRow[0][0];
}

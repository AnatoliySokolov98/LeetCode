function minFallingPathSum(grid: number[][]): number {
  const N = grid.length;
  if (N === 1) {
    return grid[0][0];
  }

  let smallest = [0, -1];
  let biggest = [0, -1];

  for (let row = 0; row < N; row++) {
    let currRow = new Array<[number, number]>();
    for (let col = 0; col < N; col++) {
      if (col !== smallest[1]) {
        currRow.push([grid[row][col] + smallest[0], col]);
      } else {
        currRow.push([grid[row][col] + biggest[0], col]);
      }
      if (currRow.length > 2) {
        currRow.sort((a, b) => a[0] - b[0]);
        currRow.pop();
      }
    }
    currRow.sort((a, b) => a[0] - b[0]);
    biggest = currRow.pop()!;
    smallest = currRow.pop()!;
  }
  return smallest[0];
}

function maxPoints(points: number[][]): number {
  const ROWS = points.length;
  const COLS = points[0].length;
  let prevRow: number[] = new Array(COLS).fill(0);

  for (let i = 0; i < COLS; i++) {
    prevRow[i] = points[0][i];
  }

  for (let i = 1; i < ROWS; i++) {
    let left = 0;
    const currRow: number[] = new Array(COLS).fill(0);

    for (let j = 0; j < COLS; j++) {
      left = Math.max(left - 1, prevRow[j]);
      currRow[j] = left + points[i][j];
    }

    let right = 0;
    for (let j = COLS - 1; j >= 0; j--) {
      right = Math.max(right - 1, prevRow[j]);
      currRow[j] = Math.max(currRow[j], right + points[i][j]);
    }

    prevRow = currRow;
  }

  let res = 0;
  for (let j = COLS - 1; j >= 0; j--) {
    res = Math.max(res, prevRow[j]);
  }

  return res;
}

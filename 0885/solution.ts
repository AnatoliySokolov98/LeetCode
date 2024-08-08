function spiralMatrixIII(
  rows: number,
  cols: number,
  rStart: number,
  cStart: number
): number[][] {
  const total = rows * cols;
  const res: Array<Array<number>> = [];
  const dirs = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  let d = 0;
  let moves = 0;
  let x = rStart;
  let y = cStart;
  res.push([x, y]);
  while (res.length < total) {
    const steps = Math.floor(moves / 2) + 1;
    for (let j = 0; j < steps; j++) {
      x += dirs[d][0];
      y += dirs[d][1];
      if (x >= 0 && x < rows && y >= 0 && y < cols) {
        res.push([x, y]);
      }
    }
    moves++;
    d = (d + 1) % 4;
  }
  return res;
}

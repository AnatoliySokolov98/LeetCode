function construct2DArray(
  original: number[],
  m: number,
  n: number
): number[][] {
  if (m * n != original.length) {
    return [];
  }
  const res = Array(m)
    .fill(0)
    .map((el) => Array(n).fill(0));

  for (let r = 0; r < m; r++) {
    for (let c = 0; c < n; c++) {
      res[r][c] = original[r * n + c];
    }
  }
  return res;
}

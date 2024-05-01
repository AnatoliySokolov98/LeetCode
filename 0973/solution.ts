function kClosest(points: number[][], k: number): number[][] {
  const res: Array<Array<number>> = [];
  for (const [x, y] of points) {
    const dist = (x ** 2 + y ** 2) ** 0.5;
    res.push([dist, x, y]);
  }
  res.sort((a, b) => a[0] - b[0]);
  return res.map((el) => el.slice(1, 3)).slice(0, k);
}
